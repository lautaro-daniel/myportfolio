package com.portfoliolautaro.productsservice.service;

import com.portfoliolautaro.productsservice.model.Product;
import com.portfoliolautaro.productsservice.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    IProductRepository iProductRepository;

    @Override
    public List<Product> getProducts() {
        return iProductRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepository.save(product);
    }
    @Override
    public Product getProduct(Long product_code) {
        return iProductRepository.findById(product_code).orElse(null);
    }
}
