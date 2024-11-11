package com.DDPointofSale.domain.product;

import jakarta.inject.Inject;

public class ProductService {
    ProductRepository categoryRepository;

    @Inject
    public ProductService(ProductRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
}
