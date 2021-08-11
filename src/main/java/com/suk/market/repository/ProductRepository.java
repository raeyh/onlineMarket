package com.suk.market.repository;

import com.suk.market.domain.Product;
import com.suk.market.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Set<Product> findAllBySeller(Seller seller);
    @Query("select p from Product p where p.category.id = :category_id")
    List<Product> findAllProductsByCategory(@Param("category_id") long id);

    @Query("select p from Product p where p.cart.id = :cart_id")
    List<Product> findAllProductsByCart(@Param("cart_id") long id);
}
