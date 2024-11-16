package com.DDPointofSale.config;


import com.DDPointofSale.web.controller.CategoryController;
import com.DDPointofSale.web.controller.ProductController;
import com.DDPointofSale.web.controller.TransactionController;
import com.DDPointofSale.web.controller.UserController;
import com.DDPointofSale.security.userauth.AuthenticationController;
import com.DDPointofSale.security.util.AuthHandler;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.javalin.Javalin;
import io.javalin.http.Header;
import io.javalin.http.staticfiles.Location;

import java.util.Properties;

import io.javalin.plugin.bundled.CorsPluginConfig;
import io.javalin.community.ssl.SslPlugin;
import javalinjwt.JavalinJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.DDPointofSale.security.RoleUser.*;
import static io.javalin.apibuilder.ApiBuilder.*;

public class AppConfig {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    private static final Integer serverport;
    private static final Properties prop = PropertiesUtil.getConfig();

    private static final Injector injector = Guice.createInjector(new ModuleConfig());

    static {
        serverport = Integer.valueOf(prop.getProperty("server.port"));
    }

    static SslPlugin plugin = new SslPlugin(conf -> {
        conf.pemFromClasspath("certs/cert.pem", "certs/key.pem");
        conf.insecure = false;
//        conf.insecurePort = serverport;
        conf.secure = true;
        conf.securePort = serverport;
        conf.sniHostCheck = true;
        conf.http2 = true;
        // additional configuration options
    });

    public static Javalin mainSetup() {
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(plugin);
            config.bundledPlugins.enableSslRedirects();
            config.staticFiles.add("/static", Location.CLASSPATH);
            config.bundledPlugins.enableCors(corsPluginConfig -> {
                corsPluginConfig.addRule(CorsPluginConfig.CorsRule::anyHost);
            });
            config.router.apiBuilder(() -> {

                path("/app", () -> {
                    //user endpoints; mutable
                    crud("/user/{user}",
                            injector.getInstance(UserController.class),
                            ADMIN);
                    path("/userid/", () -> {
                        get("{id}",
                                ctx -> injector.getInstance(UserController.class).getbyID(ctx, ctx.pathParam("id")),
                                ADMIN);
                    });

                    //transaction endpoints; immutable
                    path("/transaction", () -> {
                        get("/",
                                ctx -> injector.getInstance(TransactionController.class).getAllTransac(ctx),
                                ADMIN);
                        post("/",
                                ctx -> injector.getInstance(TransactionController.class).saveTransac(ctx),
                                USER, ADMIN);
                        get("/{id}",
                                ctx -> injector.getInstance(TransactionController.class).getTransac(ctx, ctx.pathParam("id")),
                                USER, ADMIN);

                    });

                    //category endpoints; mutable
                    crud("/category/{category}", injector.getInstance(CategoryController.class), USER, ADMIN);

                    //
                    crud("/product/{product}", injector.getInstance(ProductController.class), ADMIN);
                });

            });

            config.spaRoot.addFile("/", "/static/index.html");
        });

        app.before(AuthHandler.decode);

        app.get("test", ctx -> {
            DecodedJWT jwt = JavalinJWT.getDecodedFromContext(ctx);
            System.out.println(jwt.getClaim("name").asString());
            System.out.println(jwt.getClaim("role").asString());
            ctx.header(Header.WWW_AUTHENTICATE, "Bearer "+jwt.getToken());
        });

//        app.get("/refresh",ctx -> AuthHandler.getRefreshToken(ctx))

        app.post("/login",
                ctx -> injector.getInstance(AuthenticationController.class).login(ctx));
        app.post("/register",
                ctx -> injector.getInstance(AuthenticationController.class).register(ctx));
        app.beforeMatched("app/*", AuthHandler.accessManager);

        return app;

    }
}
