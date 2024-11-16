package com.DDPointofSale.web.controller;

import com.DDPointofSale.domain.dao.Category;
import com.DDPointofSale.domain.dao.User;
import com.DDPointofSale.domain.service.CategoryService;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import io.javalin.validation.BodyValidator;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

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
        BodyValidator<Category> validator = context.bodyValidator(Category.class)
                .check(it -> it.getCatename() != null, "Category must have name")
                .check(it -> it.getCatedesc() != null, "Category must have description");
        if (validator.errors().isEmpty()) {
            try {
                categoryService.addCategory(validator.get());
                context.json(Map.of("status", "success")).status(201);
            } catch (Exception e) {
                context.json(Map.of("error", e,
                        "Category", "Does not Exist")).status(500);
            }
        } else {
            context.status(422).json(validator.errors());
        }

    }

    /**
     * @param context
     */
    @Override
    public void getAll(@NotNull Context context) {
        try {
            var res = categoryService.getCategories();
            if (res != null) {
                context.json(res).status(200);
            } else {
                context.json(Map.of("status", "error")).status(500);
            }
        } catch (Exception e) {
            context.json(Map.of("error", e,
                    "Category", "Does not Exist")).status(500);
        }
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {
        try {
            var res = categoryService.getCategory(s);
            if (res != null) {
                context.json(res).status(200);
            } else {
                context.json(Map.of("status", "error")).status(404);
            }
        } catch (Exception e) {
            context.json(Map.of("error", e,
                    "Product", "Does not Exist")).status(500);
        }
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        BodyValidator<Category> validator = context.bodyValidator(Category.class)
                .check(it -> it.getCatedesc() != null, "user must have first name")
                .check(it -> it.getCatename() != null, "user must have last name");
        if (validator.errors().isEmpty()) {
            try {
                var res = categoryService.updateCategory(validator.get(), s);
                if (res != null) {
                    context.json(res).status(201);
                } else {
                    context.json(Map.of("status", "error")).status(500);
                }
            } catch (Exception e) {
                context.json(Map.of("error", e,
                        "Category", "Does not Exist")).status(500);
            }
        } else {
            context.json(validator.errors()).status(422);
        }
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void delete(@NotNull Context context, @NotNull String s) {
        try {
            categoryService.deleteCategory(s);
            context.json(Map.of("status", "success")).status(204);
        } catch (Exception e) {
            context.json(Map.of("status", "error",
                    "User", "Does not Exist")).status(500);
        }
    }
}
