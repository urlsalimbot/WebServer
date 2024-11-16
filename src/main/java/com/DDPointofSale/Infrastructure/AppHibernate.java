package com.DDPointofSale.Infrastructure;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.function.Consumer;
import java.util.function.Function;

public class AppHibernate {

    public SessionFactory app;

    public AppHibernate() {
        this.app = AppHibernateSessionFactory.getSessionFactory();
    }

    public void inTransaction(Consumer<Session> consumer) {
        app.inTransaction(consumer);
    }

    public <R> R fromTransaction(Function<Session, R> function) {
        return app.fromTransaction(function);
    }

}