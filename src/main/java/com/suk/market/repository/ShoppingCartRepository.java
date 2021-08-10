package com.suk.market.repository;

import com.suk.market.domain.Buyer;
import com.suk.market.domain.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart findShoppingCartByBuyer(Buyer buyer);
    ShoppingCart findFirstByBuyer(Buyer buyer);
}
