package com.suk.market.repository;

import com.suk.market.domain.Buyer;
import com.suk.market.domain.Order;
import com.suk.market.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByBuyer(Buyer buyer);

    Order findFirstByProduct(Product product);

    List<Order> findAllByProduct(Product product);
}
