package com.DDPointofSale.domain.category;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository
{
    public List<Category> listCategories();

    public Optional<Category> readCategory(String categoryName);

    public Category save(Category category);

}
