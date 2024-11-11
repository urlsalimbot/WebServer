package com.DDPointofSale.domain.user;

import com.DDPointofSale.Infrastructure.AppHibernate;

import org.hibernate.query.criteria.CriteriaDefinition;
import java.util.List;
import java.util.Optional;

/**
 * Repository dealing with Users.
 */
public class UserRepository implements IUserRepository {

    @Override
    public List<User> getAllUsers() {
        return AppHibernate.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(session, User.class) {
                {
                    var user = from(User.class);
                    orderBy(asc(user.get(User_.fName)));
                }
            };
            return session.createQuery(query).getResultList();
        });
    }

    @Override
    public List<User> getbyName(String username) {
        return AppHibernate.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(session, User.class) {{
                            var user = from(User.class);
                            where(like(user.get(User_.fName), username));
                            orderBy(asc(user.get(User_.empID)));
                        }};
            return session.createQuery(query).setMaxResults(10).getResultList();
        });
    }

    /**
     * @param user
     * @return
     */
    @Override
    public User addUser(User user) {
        return AppHibernate.fromTransaction(session -> {
            var insertedId = session.insert(user);
            return session.get(User.class, insertedId);
        });
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<User> getbyID(int id) {
        return Optional.ofNullable(AppHibernate.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(session, User.class) {{
                var user = from(User.class);
                where(equal(user.get(User_.empID), id));
                orderBy(asc(user.get(User_.empID)));
            }};
            return session.createQuery(query).getSingleResult();
        }));
    }

}