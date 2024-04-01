package com.portfoliolautaro.salesservice.controller;

import com.portfoliolautaro.salesservice.dto.SaleDTO;
import com.portfoliolautaro.salesservice.model.Sale;
import com.portfoliolautaro.salesservice.service.ISalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/sales")
@RestController
public class SaleController {

    @Autowired
    private ISalesService iSalesService;

    @GetMapping("/getAll")
    public List<Sale> getSales(){
        return iSalesService.getSales();
    }

    @PostMapping("/save")
    public String saveSale(@RequestBody Sale sale){
        iSalesService.saveSale(sale);
        return "Sale saved successfully";
    }

    @GetMapping("/carts/{sale_id}")
    public SaleDTO findCartBySaleId(@PathVariable("sale_id") Long sale_id){
        return iSalesService.findSaleByCartId(sale_id);
    }
}
