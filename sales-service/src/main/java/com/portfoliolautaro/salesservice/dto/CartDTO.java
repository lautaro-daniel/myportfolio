package com.portfoliolautaro.salesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long cart_id;
    private Double total_price;
    private List<String> productsDTO_list;
}
