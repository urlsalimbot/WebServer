package com.DDPointofSale.domain.category;

import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class CategoryService {
    CategoryRepository categoryRepository;

    @Inject
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getCategories() {
        return categoryRepository.listCategories();
    }

    public Optional<Category> getCategory(String s) {
        return categoryRepository.readCategory(s);
    }

    public Optional<Category> updateCategory(Category category, String s) {
        return null;
    }

    public void deleteCategory(String s) {

    }
}
