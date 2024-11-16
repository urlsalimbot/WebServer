package com.DDPointofSale.security.userauth;

import com.DDPointofSale.Infrastructure.AppHibernate;
import jakarta.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.query.criteria.CriteriaDefinition;


public class AuthenticationRepository implements IAuthenticationRepository {
    SessionFactory sessionFactory;

    @Inject
    public AuthenticationRepository(AppHibernate hibernate) {
        this.sessionFactory = hibernate.app;
    }

    /**
     * START OF USERAUTH Repository
     *
     * @param username
     * @return
     */
    @Override
    public UserAuth getbyUsername(String username) {
        var res = sessionFactory.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(sessionFactory, UserAuth.class) {{
                var user = from(UserAuth.class);
                where(equal(user.get(UserAuth_.username), username));
            }};
            return session.createQuery(query).uniqueResult();
        });
        return res;
    }

    /**
     * @param user
     */
    @Override
    public void save(UserAuth user) {
        sessionFactory.inTransaction(session -> {
            session.persist(user);
        });
    }
}
