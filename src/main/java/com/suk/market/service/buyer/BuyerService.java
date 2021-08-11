package com.suk.market.service.buyer;

import com.suk.market.domain.*;
import com.suk.market.dto.OrderDTO;

import java.util.List;

public interface BuyerService {
    List<Buyer> getAll();
    Buyer findBuyerById(long id);

    Buyer addBuyer(Buyer buyer);

    List<Order> findBuyerOrdersById(long id);

    Review addReviewByBuyerId(Review review, long id, long productId);

    List<Review> findReviewsByBuyerId(long id);

    Address addAddressToBuyer(Address address, long id);

    List<Address> getAddressesOfBuyer(long id);

    List<Product> findOrCreateShoppingCart(long id);

    List<Product> addProductsToCart(List<Product> products, long id);

    List<Product> clearShoppingCart(long id);

    Reciept orderReciept(OrderDTO orderDTO, long id);
}
