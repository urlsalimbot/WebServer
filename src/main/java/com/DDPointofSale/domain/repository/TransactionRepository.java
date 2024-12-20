package com.DDPointofSale.domain.repository;

import com.DDPointofSale.Infrastructure.AppHibernate;
import com.DDPointofSale.domain.dao.*;
import com.DDPointofSale.domain.repository.interfaces.ITransactionRepository;
import jakarta.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.CriteriaDefinition;

import java.util.List;
import java.util.Optional;

public class TransactionRepository implements ITransactionRepository {
    SessionFactory sessionFactory;

    @Inject
    public TransactionRepository(AppHibernate hibernate) {
        this.sessionFactory = hibernate.app;
    }

    /**
     * @param transaction
     */
    @Override
    public Transaction save(Transaction transaction) {
        var res = sessionFactory.fromTransaction(session ->{
            session.persist(transaction);
            return transaction;
    });
        return res;

    }

    @Override
    public List<Sale> getsalesbyID(Integer id) {
        var res = sessionFactory.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(sessionFactory, Sale.class) {{
                var user = from(Sale.class);
                var join = user.join("product");
                select(user);
                where(equal(join.get(Product_.ID), id));
            }};
            return session.createQuery(query).getResultList();
        });
        return res;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Transaction > findById(int id) {
        var res = sessionFactory.fromTransaction(session ->
                session.get(Transaction.class, id));
        return Optional.of(res);
    }

    /**
     * @return
     */
    @Override
    public List<Transaction> findAllTransactions() {
        return sessionFactory.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(sessionFactory, Transaction.class) {
                {
                    var user = from(Transaction.class);
                    orderBy(asc(user.get(Transaction_.ID)));
                }
            };
            return session.createQuery(query).getResultList();
        });
    }
}
