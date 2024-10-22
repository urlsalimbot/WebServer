package com.WebAppTest.Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseUtil.class);

    public static Connection connection(String dburl, String name, String pword){
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(dburl,name,pword);
            if (conn != null){
                logger.info("Connection Successful");
            }
            else {
                logger.warn("Connection Failed");
            }
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return conn;
    }
}
