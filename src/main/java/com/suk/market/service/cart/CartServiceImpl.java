package com.suk.market.service.cart;

import com.suk.market.domain.Cart;
import com.suk.market.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    CartRepository cartRepository;

    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public Iterable<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findCartById(long id) {
        return cartRepository.findById(id);
    }

    @Override
    public void save(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCartById(long id) {
        cartRepository.deleteById(id);
    }
}
