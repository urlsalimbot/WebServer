package com.WebAppTest.Config;

import com.WebAppTest.Utils.DatabaseUtil;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinThymeleaf;

import java.util.HashMap;
import java.util.Map;

import static com.WebAppTest.Utils.DatabaseUtil.connection;
import static com.WebAppTest.Utils.SessionUtil.sqlSessionHandler;

public class WebAppConfig {
    private static final String dburl = "jdbc:postgresql://localhost:5432/TestDB";
    private static final String dbname = "postgres";
    private static final String dbpword = "123";
    private static final String dbdriver = "org.postgresql.Driver";
    private static final String dburl2 = String.format("jdbc:postgresql://localhost:5432/TestDB?user=%s&password=%s",dbname,dbpword);

    public static Javalin mainSetup(){
        DatabaseUtil db = new DatabaseUtil();
        connection(dburl,dbname,dbpword);

         Javalin app = Javalin.create( config -> {
            config.jetty.modifyServletContextHandler(handler -> handler.setSessionHandler(sqlSessionHandler(dbdriver,dburl2)));
            config.staticFiles.add("/public", Location.CLASSPATH);
            config.fileRenderer(new JavalinThymeleaf());
            
            //config.spaRoot.addFile("/", "src/main/resources/public/index.html", Location.EXTERNAL);
            });

         app.error(404, ctx -> ctx.result("Not found!"));

         app.get("/test",TEST);

         return app;
    }

    private static final Handler TEST = (ctx) -> {
        Map<String, Object> model = new HashMap<>();
        model.put("hello", "Hello, World. :)");
        ctx.render("test.html", model);
    };
}
