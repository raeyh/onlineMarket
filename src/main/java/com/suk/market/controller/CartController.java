package com.suk.market.controller;

import com.suk.market.domain.Cart;
import com.suk.market.service.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {
    CartService cartService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public Iterable<Cart> findAllCart(){
        return cartService.findAllCart();
    }

    @GetMapping("/{id}")
    public Optional<Cart> findCartById(@PathVariable("id") long id){
        return cartService.findCartById(id);
    }

    @PostMapping
    public void save(@RequestBody Cart cart){
        cartService.save(cart);
    }

    @PutMapping
    public void updateCart(@RequestBody Cart cart){
        cartService.save(cart);
    }

    @DeleteMapping("/{id}")
    public void deleteCartById(@PathVariable("id") long id){
        cartService.deleteCartById(id);
    }
}