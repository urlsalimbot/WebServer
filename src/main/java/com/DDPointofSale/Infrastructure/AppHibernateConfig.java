package com.DDPointofSale.Infrastructure;


import com.DDPointofSale.domain.dao.Category;
import com.DDPointofSale.domain.dao.Customer;
import com.DDPointofSale.domain.dao.Product;
import com.DDPointofSale.domain.dao.Sale;
import com.DDPointofSale.domain.dao.Transaction;
import com.DDPointofSale.domain.dao.User;
import com.DDPointofSale.security.userauth.UserAuth;
import org.eclipse.jetty.server.Authentication;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.schema.Action;

import java.util.Properties;

class AppHibernateConfig {

    static Configuration configuration() {
        var configuration = new Configuration();
        var settings = new Properties();
        settings.put(AvailableSettings.CONNECTION_PROVIDER, "org.hibernate.hikaricp.internal.HikariCPConnectionProvider");
        settings.put(AvailableSettings.HIKARI_MIN_IDLE_SIZE, "5");
        settings.put(AvailableSettings.HIKARI_MAX_SIZE, "30");
        settings.put(AvailableSettings.HIKARI_IDLE_TIMEOUT, "300");
        settings.put(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/TestDB");
        settings.put(AvailableSettings.JAKARTA_JDBC_USER, "postgres");
        settings.put(AvailableSettings.JAKARTA_JDBC_PASSWORD, "123");
        settings.put(AvailableSettings.HIGHLIGHT_SQL, true);
//        settings.put(AvailableSettings.SHOW_SQL, true);
//        settings.put(AvailableSettings.FORMAT_SQL, true);
        settings.put(AvailableSettings.HBM2DDL_AUTO, Action.UPDATE);

        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Category.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Product.class);
        configuration.addAnnotatedClass(Sale.class);
        configuration.addAnnotatedClass(Transaction.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserAuth.class);
        configuration.addAnnotatedClass(Authentication.class);

        return configuration;
    }

}