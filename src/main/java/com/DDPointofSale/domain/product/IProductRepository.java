package com.DDPointofSale.domain.product;

import java.util.List;
import java.util.Optional;

public interface IProductRepository
{
    public List<Product> listProducts();

    public Optional<Product> readProduct(String productName);

}
