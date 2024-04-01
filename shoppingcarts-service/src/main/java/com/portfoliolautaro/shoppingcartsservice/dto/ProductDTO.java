package com.portfoliolautaro.shoppingcartsservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long product_code;
    private String product_name;
    private String product_brand;
    private double unit_price;
    private Long cart_id;
}
