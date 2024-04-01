package com.portfoliolautaro.productsservice.service;

import com.portfoliolautaro.productsservice.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> getProducts();
    public void saveProduct(Product product);
    public Product getProduct(Long product_code);
}
