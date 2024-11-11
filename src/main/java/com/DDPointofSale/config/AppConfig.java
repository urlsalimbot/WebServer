package com.DDPointofSale.config;


import com.DDPointofSale.domain.category.CategoryController;
import com.DDPointofSale.domain.transaction.TransactionController;
import com.DDPointofSale.domain.user.UserController;
import com.DDPointofSale.security.RoleUser;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.sql.Connection;
import java.util.Properties;

import io.javalin.plugin.bundled.CorsPluginConfig;
import io.javalin.community.ssl.SslPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
         Javalin app = Javalin.create( config -> {
             config.registerPlugin(plugin);
             config.bundledPlugins.enableSslRedirects();
             config.staticFiles.add("/static", Location.CLASSPATH);
             config.bundledPlugins.enableCors(corsPluginConfig -> {
                 corsPluginConfig.addRule(CorsPluginConfig.CorsRule::anyHost);
             });
             config.router.apiBuilder(() -> {

                 //user endpoints; mutable
                 crud("/users/{user}", injector.getInstance(UserController.class));
                 path("/userid/", () -> {
                             get("/{id}",ctx -> injector.getInstance(UserController.class).getbyID(ctx,ctx.pathParam("id")));
                     });

                 //transaction endpoints; immutable
                 path("/transaction", () -> {
                     get("/", ctx ->   injector.getInstance(TransactionController.class).getAllTransac(ctx));
                     post("/", ctx ->   injector.getInstance(TransactionController.class).getSaveTransac(ctx));
                     get("/{id}", ctx ->   injector.getInstance(TransactionController.class).getTransac(ctx,ctx.pathParam("id")));

                    });

                 //category endpoints; mutable
                 crud("/category/{category}", injector.getInstance(CategoryController.class));


                 });

             config.spaRoot.addFile("/","/static/index.html");
             });
         return app;

    }
}
