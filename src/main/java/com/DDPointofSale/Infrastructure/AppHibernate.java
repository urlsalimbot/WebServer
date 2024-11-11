package com.DDPointofSale.Infrastructure;

import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.StatelessSession;

import java.util.function.Consumer;
import java.util.function.Function;

public class AppHibernate {

    public static void inTransaction(Consumer<Session> consumer) {
        AppHibernateSessionFactory.getSessionFactory().inTransaction(consumer);
    }

    public static  <R> R fromTransaction(Function<StatelessSession, R> function) {
        return AppHibernateSessionFactory.getSessionFactory().fromStatelessTransaction(function);
    }

}