package com.WebAppTest.Utils;

import org.eclipse.jetty.server.session.*;

public class SessionUtil {

    public static SessionHandler sqlSessionHandler(String driver, String url){
        SessionHandler sessionHandler = new SessionHandler();
        SessionCache sessionCache = new DefaultSessionCache(sessionHandler);
        sessionCache.setSessionDataStore(
                jdbcDataStoreFactory(driver,url).getSessionDataStore(sessionHandler)
        );
        sessionHandler.setSessionCache(sessionCache);
        sessionHandler.setHttpOnly(true);

        return sessionHandler;
    }

    public static JDBCSessionDataStoreFactory jdbcDataStoreFactory(String driver, String url){
        DatabaseAdaptor databaseAdaptor = new DatabaseAdaptor();
        databaseAdaptor.setDriverInfo(driver,url);

        JDBCSessionDataStoreFactory jdbcSessionDataStoreFactory = new JDBCSessionDataStoreFactory();
        jdbcSessionDataStoreFactory.setDatabaseAdaptor(databaseAdaptor);

        return jdbcSessionDataStoreFactory;
    }

}
