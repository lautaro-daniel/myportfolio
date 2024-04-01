package com.portfoliolautaro.salesservice.service;

import com.portfoliolautaro.salesservice.dto.CartDTO;
import com.portfoliolautaro.salesservice.dto.SaleDTO;
import com.portfoliolautaro.salesservice.model.Sale;
import com.portfoliolautaro.salesservice.repository.CartAPI;
import com.portfoliolautaro.salesservice.repository.ISaleRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISalesService{

    @Autowired
    private ISaleRepository iSaleRepository;

    @Autowired
    private CartAPI cartAPI;
    @Override
    public List<Sale> getSales() {
        return iSaleRepository.findAll();
    }

    @Override
    public void saveSale(Sale sale) {
        iSaleRepository.save(sale);
    }

    @Override
    public Sale findSale(Long sale_id) {
        return iSaleRepository.findById(sale_id).orElse(null);
    }

    @Override
    public void deleteSale(Long sale_id) {
        iSaleRepository.deleteById(sale_id);
    }

    @Override
    @CircuitBreaker(name = "carts-service", fallbackMethod = "fallbackFindSaleByCartId")
    @Retry(name = "carts-service")
    public SaleDTO findSaleByCartId(Long sale_id) {
        Sale sale = iSaleRepository.findById(sale_id).orElse(null);

        CartDTO cartDTO = cartAPI.getCartBySaleId(sale.getSale_id());
        //createException();

        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSale_date(sale.getSale_date());
        saleDTO.setSale_id(sale.getSale_id());
        saleDTO.setCart_id(sale.getCart_id());
        saleDTO.setCartDTO(cartDTO);

        return saleDTO;
    }

    public SaleDTO fallbackFindSaleByCartId(Throwable throwable){
        return new SaleDTO(99999999L, LocalDate.now(), 999999L, null);
    }

    public void createException(){
        throw new IllegalArgumentException("Test Resilience and Circuit Breaker by portfolio");
    }
}
