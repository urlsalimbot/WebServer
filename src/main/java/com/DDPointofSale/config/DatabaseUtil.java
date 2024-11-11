package com.DDPointofSale.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.util.Properties;
import javax.sql.DataSource;

public class DatabaseUtil{

    private static final String DB_NAME = "db.name";
    private static final String DB_PASSWORD = "db.pword";
    private static final String DB_URL = "db.url";
    private static final String DB_DRIVER_CLASS = "db.driver.name";

    private static Properties prop = PropertiesUtil.getConfig();
    private static HikariDataSource dataSource;
    private static HikariConfig config;

    static {
        config = new HikariConfig();
        config.setJdbcUrl(prop.getProperty(DB_URL));
        config.setUsername(prop.getProperty(DB_NAME));
        config.setPassword(prop.getProperty(DB_PASSWORD));
        config.setDriverClassName(prop.getProperty(DB_DRIVER_CLASS));

        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}
