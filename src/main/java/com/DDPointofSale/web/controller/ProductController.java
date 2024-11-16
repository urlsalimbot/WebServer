package com.DDPointofSale.web.controller;

import com.DDPointofSale.domain.dao.Product;
import com.DDPointofSale.domain.dao.User;
import com.DDPointofSale.domain.dto.ProductDTO;
import com.DDPointofSale.domain.service.ProductService;
import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import io.javalin.validation.BodyValidator;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class ProductController implements CrudHandler {
    ProductService productService;

    @Inject
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * @param context
     */
    @Override
    public void create(@NotNull Context context) {
        BodyValidator<ProductDTO> validator = context.bodyValidator(ProductDTO.class)
                .check(it -> it.getProductname() != null, "Product must have name")
                .check(it -> it.getStock() > 0, "Product must have price")
                .check(it -> it.getPrice().intValue() > 0, "Product must have description")
                .check(it -> it.getCategoryidId() != null, "Product must have categoryid");
        if (validator.errors().isEmpty()) {
            try {
                var res = productService.save(validator.get());
                context.json(Map.of("status", "success")).status(201);
            } catch (Exception e) {
                context.json(Map.of("error", e,
                        "Product", "Does not Exist")).status(500);
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
            List<Product> res = productService.getAllProds();
            if (!res.isEmpty()) {
                context.json(res).status(200);
            } else {
                context.json(Map.of("status", "error",
                        "Products","Do not exist")).status(422);
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
    public void getOne(@NotNull Context context, @NotNull String s) {
        try {
            var res = productService.getbyname(s);
            if (res != null) {
                context.json(res).status(200);
            } else {
                context.json(Map.of("status", "error")).status(422);
            }
        } catch (Exception e) {
            context.json(Map.of("status", "error",
                    "Product", "Does not Exist")).status(500);
        }
    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void update(@NotNull Context context, @NotNull String s) {
        BodyValidator<ProductDTO> validator = context.bodyValidator(ProductDTO.class)
                .check(it -> it.getProductname() != null, "user must have first name")
                .check(it -> it.getStock() > 0, "user must have last name")
                .check(it -> it.getPrice().intValue() > 0, "user must have job")
                .check(it -> it.getCategoryidId() != null, "user must have email");
        if (validator.errors().isEmpty()) {
            try {
                var res = productService.update(validator.get(), s);
                if (res != null) {
                    context.json(res).status(201);
                } else {
                    context.json(Map.of("status", "error")).status(500);
                }
            } catch (Exception e) {
                context.json(Map.of("error", e,
                        "Product", "Does not Exist")).status(500);
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
            productService.delete(s);
            context.json(Map.of("status", "success")).status(204);
        } catch (Exception e) {
            context.json(Map.of("status", "error",
                    "User", "Does not Exist")).status(500);
        }
    }
}
