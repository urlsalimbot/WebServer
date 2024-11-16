package com.DDPointofSale.security.token;

import com.DDPointofSale.Infrastructure.AppHibernate;
import jakarta.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.CriteriaDefinition;

import java.util.List;

public class TokenRepository implements ITokenRepository {
    SessionFactory sessionFactory;

    @Inject
    public TokenRepository(AppHibernate hibernate) {
        this.sessionFactory = hibernate.app;
    }

    /**
     * @return
     */
    @Override
    public List<Token> getValidTokens() {
        return List.of();
    }

    /**
     * @param token@return
     */
    @Override
    public Token findbyToken(String token) {
        return null;
    }

    /**
     * @param token
     */
    public void save(Token token) {
        sessionFactory.fromTransaction(session -> {
            var query = new CriteriaDefinition<>(sessionFactory, Token.class){{
                var token = from(Token.class);
                where(equal(token.get(Token_.token), token));
            }}.createSelectionQuery(session).uniqueResult();
            if (query != null) {
                session.persist(token);
                return token;
            }
            return null;
        });


    }

}
