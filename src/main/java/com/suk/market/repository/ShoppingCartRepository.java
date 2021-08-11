package com.suk.market.repository;

import com.suk.market.domain.Buyer;
import com.suk.market.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<Cart, Long> {
    Cart findShoppingCartByBuyer(Buyer buyer);
    Cart findFirstByBuyer(Buyer buyer);
}
