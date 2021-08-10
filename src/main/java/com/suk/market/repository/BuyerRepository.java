package com.suk.market.repository;

import com.suk.market.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerRepository extends JpaRepository<Buyer, Long> {
}
