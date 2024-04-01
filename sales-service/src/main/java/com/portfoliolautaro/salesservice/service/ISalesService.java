package com.portfoliolautaro.salesservice.service;

import com.portfoliolautaro.salesservice.dto.SaleDTO;
import com.portfoliolautaro.salesservice.model.Sale;

import java.util.List;

public interface ISalesService {
    List<Sale> getSales();
    public void saveSale(Sale sale);
    Sale findSale(Long sale_id);
    public void deleteSale(Long sale_id);
    SaleDTO findSaleByCartId(Long sale_id);

}
