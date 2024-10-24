package com.WebAppTest.config;


import com.WebAppTest.utils.PropertiesUtil;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.WebAppTest.utils.DatabaseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebAppConfig {
    private static final Logger logger = LoggerFactory.getLogger(WebAppConfig.class);

    private static final Integer serverport;
    private static final Properties prop = PropertiesUtil.getConfig();

    static {
        serverport = Integer.valueOf(prop.getProperty("server.port"));
    }

    public static Javalin mainSetup() {
        try {
            Connection connection = DatabaseUtil.getDataSource().getConnection();
            logger.info("Connection Successful!");
        }
        catch (Exception e){
            logger.warn(e.getMessage());
        }

         Javalin app = Javalin.create( config -> {
             config.jetty.defaultPort = serverport;
             config.staticFiles.add("/public", Location.CLASSPATH);
             config.fileRenderer(new JavalinThymeleaf());
            //config.spaRoot.addFile("/", "src/main/resources/public/index.html", Location.EXTERNAL);
            });

         app.get("/test",TEST);

         //404 response
         app.error(404, ctx -> ctx.result("Not found!"));

         return app;
    }

    private static final Handler TEST = (ctx) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("hello", "Hello, World. :)");
        ctx.render("test.html", model);
    };
}
