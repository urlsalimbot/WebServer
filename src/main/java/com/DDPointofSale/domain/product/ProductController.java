package com.DDPointofSale.domain.product;

import io.javalin.apibuilder.CrudHandler;
import io.javalin.http.Context;
import jakarta.inject.Inject;
import org.jetbrains.annotations.NotNull;

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

    }

    /**
     * @param context
     */
    @Override
    public void getAll(@NotNull Context context) {

    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void getOne(@NotNull Context context, @NotNull String s) {

    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void update(@NotNull Context context, @NotNull String s) {

    }

    /**
     * @param context
     * @param s
     */
    @Override
    public void delete(@NotNull Context context, @NotNull String s) {

    }
}
