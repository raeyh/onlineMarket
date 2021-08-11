package com.suk.market.service.cart;

import com.suk.market.domain.Cart;

import java.util.Optional;

public interface CartService {
    Iterable<Cart> findAllCart();
    Optional<Cart> findCartById(long id);
    void save(Cart cart);
    void updateCart(Cart cart);
    void deleteCartById(long id);

}
