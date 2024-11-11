package com.DDPointofSale.domain.category;

import com.DDPointofSale.Infrastructure.AppHibernate;
import com.DDPointofSale.domain.user.User;
import com.DDPointofSale.domain.user.User_;
import org.hibernate.query.criteria.CriteriaDefinition;

import java.util.List;
import java.util.Optional;

public class CategoryRepository implements ICategoryRepository{
    /**
     * @return
     */
    @Override
    public List<Category> listCategories() {
        return List.of();
    }

    /**
     * @param categoryName
     * @return
     */
    @Override
    public Optional<Category> readCategory(String categoryName) {
        return Optional.ofNullable(AppHibernate.fromTransaction(session -> {
                    var query = new CriteriaDefinition<>(session, Category.class) {{
                        var user = from(Category.class);
                        where(like(user.get(Category_.catename), categoryName));
                        orderBy(asc(user.get(Category_.id)));
                    }};
                    return session.createQuery(query).uniqueResult();
                }));
    }



    /**
     * @param category
     */
    @Override
    public Category save(Category category) {
        return AppHibernate.fromTransaction(session -> {
            var insertedId = session.insert(category);
            return session.get(Category.class, insertedId);
        });
    }

}
