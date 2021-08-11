package com.suk.market.controller;

import com.suk.market.domain.*;
import com.suk.market.dto.OrderDTO;
import com.suk.market.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyers")
public class BuyerController {
    @Autowired
    BuyerService buyerService;


    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.getAll();
    }

    @GetMapping("/{id}")
    public Buyer getBuyerById(@PathVariable Long id) {
        return buyerService.findBuyerById(id);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getBuyerReviews(@PathVariable long id) {
        return buyerService.findReviewsByBuyerId(id);
    }

    @PostMapping("/{id}/products/{productId}/reviews")
    public Review addReviewToProductByBuyer(@RequestBody Review review, @PathVariable long id, @PathVariable long productId) {
        return buyerService.addReviewByBuyerId(review, id, productId);
    }

    @PostMapping("/{id}/addresses")
    public Address addAddressToBuyer(@RequestBody Address address, @PathVariable long id) {
        return buyerService.addAddressToBuyer(address, id);
    }

    @GetMapping("/{id}/addresses")
    public List<Address> getAddressesOfBuyer(@PathVariable long id) {
        return buyerService.getAddressesOfBuyer(id);
    }

    @GetMapping("/{id}/orders")
    public List<Order> getOrdersForBuyer(@PathVariable long id) {
        return buyerService.findBuyerOrdersById(id);
    }

    @PostMapping("/{id}/sellers/{sellerId}/follow")
    public void followSeller(@PathVariable Long id, @PathVariable Long sellerId) {

    }

    @PostMapping("/{id}/sellers/{sellerId}/unfollow")
    public void unfollowSeller(@PathVariable Long id, @PathVariable Long sellerId) {

    }

    @GetMapping("/{id}/shoppingcart")
    public List<Product> getShoppingCart(@PathVariable long id) {
        return buyerService.findOrCreateShoppingCart(id);
    }

    @PatchMapping("/{id}/shoppingcart")
    public List<Product> addProductsToShoppingCart(@RequestBody List<Product> products, @PathVariable long id) {
        return buyerService.addProductsToCart(products, id);
    }

    @PatchMapping("/{id}/shoppingcart/clear")
    public List<Product> clearShoppingCart(@PathVariable long id) {
        return buyerService.clearShoppingCart(id);
    }

    @PostMapping("/{id}/shoppingcart/process")
    public Reciept orderReciept(@RequestBody OrderDTO orderDTO, @PathVariable long id) {
        return buyerService.orderReciept(orderDTO, id);
    }


}
