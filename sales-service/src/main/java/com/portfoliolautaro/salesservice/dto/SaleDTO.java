package com.portfoliolautaro.salesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long sale_id;
    private LocalDate sale_date;
    private Long cart_id;
    private CartDTO cartDTO;
}
