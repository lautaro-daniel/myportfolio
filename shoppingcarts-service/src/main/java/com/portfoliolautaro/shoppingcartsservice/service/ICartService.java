package com.portfoliolautaro.shoppingcartsservice.service;

import com.portfoliolautaro.shoppingcartsservice.model.Cart;

import java.util.List;

public interface ICartService {

    List<Cart> getCarts();
    public void saveCart(Cart cart);
    Cart findCart(Long cart_id);
    public void addProductToCart(Long id_cart, Long product_code);

    public void deleteProductToCart(Long id_cart, Long product_code);

}
