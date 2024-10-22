package com.WebAppTest;

import com.WebAppTest.Utils.DatabaseUtil;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
    import com.WebAppTest.Config.WebAppConfig;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WebAppMain {
    public static void main(String[] args) {
        WebAppConfig.mainSetup().start(7070);


//                Javalin.create(config -> {
//            config.staticFiles.add("src/main/resources/public", Location.EXTERNAL);
//            config.jetty.modifyServletContextHandler(handler -> handler.setSessionHandler(sqlSessionHandler()));
//        });
//
//        app.error(404, "html", ctx -> ctx.html("Not Found!"));
//
//        app.get("/write", ctx -> {
//            // values written to the session will be available on all your instances if you use a session db
//            ctx.sessionAttribute("my-key", "My value");
//            ctx.result("Wrote value: " + ctx.sessionAttribute("my-key"));
//        });
//
//        app.get("/read", ctx -> {
//            // values on the session will be available on all your instances if you use a session db
//            String myValue = ctx.sessionAttribute("my-key");
//            ctx.result("Value: " + myValue);
//        });
//
//        app.get("/invalidate", ctx -> {
//            // if you want to invalidate a session, jetty will clean everything up for you
//            ctx.req().getSession().invalidate();
//            ctx.result("Session invalidated");
//        });
//
//        app.get("/change-id", ctx -> {
//            // it could be wise to change the session id on login, to protect against session fixation attacks
//            ctx.req().changeSessionId();
//            ctx.result("Session ID changed");
//        });
//
//        DatabaseUtil.connection("TestDB","postgres","123");

    }

}
