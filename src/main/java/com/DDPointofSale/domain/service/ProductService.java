package com.DDPointofSale.domain.service;

import com.DDPointofSale.domain.dao.Product;
import com.DDPointofSale.domain.dao.User;
import com.DDPointofSale.domain.dto.ProductDTO;
import com.DDPointofSale.domain.repository.interfaces.ICategoryRepository;
import com.DDPointofSale.domain.repository.interfaces.IProductRepository;
import jakarta.inject.Inject;

import java.util.List;

public class ProductService {
    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;

    @Inject
    public ProductService(IProductRepository productRepository,
                          ICategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product save(ProductDTO product) {
        var cat = categoryRepository.getbyId(product.getCategoryidId());
        Product newproduct = Product.builder()
                .productname(product.getProductname())
                .stock(product.getStock())
                .price(product.getPrice())
                .categoryid(cat.get())
                .build()
                ;
        var res = productRepository.addProduct(newproduct);
        return res.orElse(null);
    }

    public List<Product> getAllProds() {
        return productRepository.getallProducts();
    }


    public Product getbyname(String s) {
        var res = productRepository.getbyName(s);
        return res.orElse(null);
    }

    public Product getUserbyID(int id) {
        var res = productRepository.getbyId(id);
        return res.orElse(null);
    }

    public Product update(ProductDTO product, String name) {
        Product newproduct = Product.builder()
                .productname(product.getProductname())
                .stock(product.getStock())
                .price(product.getPrice())
                .build();
        var res = productRepository.updateProduct(newproduct, name);
        return res.orElse(null);
    }

    public void delete(String name) {
        productRepository.delete(name);
    }

}
