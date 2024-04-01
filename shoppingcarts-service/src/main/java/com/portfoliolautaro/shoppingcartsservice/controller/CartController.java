package com.portfoliolautaro.shoppingcartsservice.controller;

import com.portfoliolautaro.shoppingcartsservice.model.Cart;
import com.portfoliolautaro.shoppingcartsservice.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private ICartService iCartService;

    @GetMapping("/get")
    public List<Cart> getCarts(){
        return iCartService.getCarts();
    }

    @GetMapping("/{cart_id}")
    public Cart getCartById(@PathVariable("cart_id") Long cart_id){
        return iCartService.findCart(cart_id);
    }

    @PostMapping("/save")
    public String saveCart(@RequestBody Cart cart){
        iCartService.saveCart(cart);

        return "Cart saved";
    }
    @PutMapping("/add")
    public String addProductToCart(@RequestParam Long cart_id, @RequestParam Long product_code){
        iCartService.addProductToCart(cart_id, product_code);

        return "Product added successfully";
    }

    @DeleteMapping("/delete")
    public String deleteProductToCart(@RequestParam Long cart_id, @RequestParam Long product_code){
        iCartService.deleteProductToCart(cart_id,product_code);

        return "Product deleted successfully";
    }
}
