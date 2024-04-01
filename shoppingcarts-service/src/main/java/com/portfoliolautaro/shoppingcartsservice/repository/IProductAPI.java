package com.portfoliolautaro.shoppingcartsservice.repository;

import com.portfoliolautaro.shoppingcartsservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "products-service")
public interface IProductAPI {
    @GetMapping("/products/code/{product_code}")
    ProductDTO getProduct(
            @PathVariable("product_code") Long product_code
    );
}
