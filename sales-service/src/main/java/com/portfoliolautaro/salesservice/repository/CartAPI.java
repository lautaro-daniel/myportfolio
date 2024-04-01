package com.portfoliolautaro.salesservice.repository;

import com.portfoliolautaro.salesservice.dto.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "carts-service")
public interface CartAPI {

    @GetMapping("/carts/{sale_id}")
    CartDTO getCartBySaleId(
            @PathVariable("sale_id") Long sale_id
    );
}
