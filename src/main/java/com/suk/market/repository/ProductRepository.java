package com.suk.market.repository;

import com.suk.market.domain.Product;
import com.suk.market.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllBySeller(Seller seller);
}
