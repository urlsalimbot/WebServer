package com.DDPointofSale.domain.product;

import java.util.List;
import java.util.Optional;

public class ProductRepository implements IProductRepository {
    /**
     * @return
     */
    @Override
    public List<Product> listProducts() {
        return List.of();
    }

    /**
     * @param productName
     * @return
     */
    @Override
    public Optional<Product> readProduct(String productName) {
        return Optional.empty();
    }
}
