package com.DDPointofSale.domain.repository.interfaces;

import com.DDPointofSale.domain.dao.Product;
import com.DDPointofSale.domain.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface IProductRepository
{
    public Optional<Product> addProduct(Product product);

    public List<Product> getallProducts();

    public Optional<Product> getbyName(String name);

    public Optional<Product> getbyId(int id);

    public Optional<Product> updateProduct(Product product, String name);

    public Optional<Product> updatebyID(Product product, Integer id);

    public void delete(String name);
}
