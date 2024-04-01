package com.portfoliolautaro.productsservice.controller;

import com.portfoliolautaro.productsservice.model.Product;
import com.portfoliolautaro.productsservice.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    IProductService iProductService;

    @GetMapping("/get")
    public List<Product> getProducts(){
        return iProductService.getProducts();
    }

    @PostMapping("/save")
    public String saveProduct(@RequestBody Product product){
        iProductService.saveProduct(product);

        return "product saved";
    }

    @Value("${server.port}")
    private int serverPort;
    @GetMapping("/code/{product_code}")
    public Product getProduct(@PathVariable Long product_code){

        System.out.println("---------Port: " + serverPort);
        return iProductService.getProduct(product_code);
    }
}
