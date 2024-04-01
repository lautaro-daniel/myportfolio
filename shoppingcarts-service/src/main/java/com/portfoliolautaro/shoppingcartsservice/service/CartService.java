package com.portfoliolautaro.shoppingcartsservice.service;

import com.portfoliolautaro.shoppingcartsservice.dto.ProductDTO;
import com.portfoliolautaro.shoppingcartsservice.model.Cart;
import com.portfoliolautaro.shoppingcartsservice.repository.ICartRepository;
import com.portfoliolautaro.shoppingcartsservice.repository.IProductAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService{

    @Autowired
    private ICartRepository iCartRepository;

    @Autowired
    private IProductAPI iProductAPI;
    @Override
    public List<Cart> getCarts() {
        return iCartRepository.findAll();
    }

    @Override
    public void saveCart(Cart cart) {
        iCartRepository.save(cart);
    }

    @Override
    public Cart findCart(Long cart_id) {
        return iCartRepository.findById(cart_id).orElse(null);
    }
    @Override
    public void addProductToCart(Long id_cart, Long product_code) {
        Cart cart = findCart(id_cart);

        ProductDTO productDTO = iProductAPI.getProduct(product_code);

        cart.getProductsDTO_list().add(productDTO.getProduct_name());
        cart.setTotal_price(cart.getTotal_price() + productDTO.getUnit_price());

        this.saveCart(cart);
    }

    @Override
    public void deleteProductToCart(Long id_cart, Long product_code) {
        Cart cart = findCart(id_cart);

        ProductDTO productDTO = iProductAPI.getProduct(product_code);

        cart.getProductsDTO_list().remove(productDTO.getProduct_name());
        cart.setTotal_price(cart.getTotal_price()-productDTO.getUnit_price());
        this.saveCart(cart);
        }
    }

