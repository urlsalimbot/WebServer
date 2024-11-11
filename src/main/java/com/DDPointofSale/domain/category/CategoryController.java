package com.DDPointofSale.domain.category;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class CategoryController implements CrudHandler {
    CategoryService categoryService;

    @Inject
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * @param context
     */
    @Override
    public void create(@NotNull Context context) {
        var category = context.bodyAsClass(Category.class);
        context.json(categoryService.addCategory(category));
    }

    /**
     * @param context
     */
    @Override
    public void getAll(@NotNull Context context) {
        context.json(categoryService.getCategories());
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        var category = categoryService.getCategory(s);
        if (category.isPresent()) {context.json(category);}
        else {context.status(404);}

    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        var category = categoryService.updateCategory(context.bodyAsClass(Category.class),s);
        if (category.isPresent()) {context.json(category);}
        else {context.status(404);}
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        categoryService.deleteCategory(s);
        context.status(204);
    }
}
