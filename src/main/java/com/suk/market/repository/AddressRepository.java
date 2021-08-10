package com.suk.market.repository;

import com.suk.market.domain.Address;
import com.suk.market.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByBuyer(Buyer buyer);
}
