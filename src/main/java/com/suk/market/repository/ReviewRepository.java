package com.suk.market.repository;

import com.suk.market.domain.Buyer;
import com.suk.market.domain.Product;
import com.suk.market.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findAllByBuyer(Buyer buyer);
    List<Review> findAllByProduct(Product product);

}
