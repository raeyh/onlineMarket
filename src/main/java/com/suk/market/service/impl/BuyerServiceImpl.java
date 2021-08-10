package com.suk.market.service.impl;

import com.suk.market.domain.*;
import com.suk.market.dto.OrderDTO;
import com.suk.market.repository.*;
import com.suk.market.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    BuyerRepository buyerRepository;
    @Autowired
    ShoppingCartRepository shoppingCartRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    RecieptRepository recieptRepository;

    @Override
    public List<Buyer> getAll() {
        return null;
    }

    @Override
    public Buyer findBuyerById(long id) {
        return buyerRepository.findById(id).orElseThrow();
    }

    @Override
    public Buyer addBuyer(Buyer buyer) {
        Buyer buyer1 = buyerRepository.save(buyer);
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setBuyer(buyer1);
        shoppingCartRepository.save(shoppingCart);
        return buyer1;

    }

    @Override
    public List<Order> findBuyerOrdersById(long id) {
        Buyer buyer = findBuyerById(id);
        return orderRepository.findAllByBuyer(buyer);

    }

    @Override
    public Review addReviewByBuyerId(Review review, long id, long productId) {
        Buyer buyer = findBuyerById(id);
        Product product = productRepository.findById(productId).get();
        review.setBuyer(buyer);
        review.setProduct(product);
        review.setApproved(false);
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findReviewsByBuyerId(long id) {
        Buyer buyer = findBuyerById(id);
        return reviewRepository.findAllByBuyer(buyer);
    }

    @Override
    public Address addAddressToBuyer(Address address, long id) {
        Buyer buyer = findBuyerById(id);
        address.setBuyer(buyer);
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getAddressesOfBuyer(long id) {
        Buyer buyer = findBuyerById(id);
        return addressRepository.findAllByBuyer(buyer);
    }

    @Override
    public List<Product> findOrCreateShoppingCart(long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartRepository.findFirstByBuyer(buyer);
        return shoppingCart.getProducts();
    }

    @Override
    public List<Product> addProductsToCart(List<Product> products, long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(products);
        return shoppingCartRepository.save(shoppingCart).getProducts();
    }

    @Override
    public List<Product> clearShoppingCart(long id) {
        Buyer buyer = findBuyerById(id);
        ShoppingCart shoppingCart = shoppingCartRepository.findShoppingCartByBuyer(buyer);
        shoppingCart.setProducts(new ArrayList<>());
        return shoppingCartRepository.save(shoppingCart).getProducts();
    }

    @Override
    public Reciept orderReciept(OrderDTO orderDTO, long id) {
        List<Product> products = findOrCreateShoppingCart(id);
        if (products.size() > 0) {
            Buyer buyer = findBuyerById(id);
            double totalPrice = products.stream().map(product -> product.getPrice()).reduce((price, total) -> price + total).get();
            System.out.println("Price Total: " + totalPrice);
            List<Order> orders = products.stream().map(product -> {
                Order order = new Order();
                order.setStatus(OrderStatus.ORDERED);
                order.setBuyer(buyer);
                order.setProduct(product);
                order.setShippingAddress(orderDTO.getShippingAddress());
                order.setBillingAddress(orderDTO.getBillingAddress());
                return order;
            }).collect(Collectors.toList());
            List<Order> savedOrders = StreamSupport.stream(orderRepository.saveAll(orders).spliterator(), false).collect(Collectors.toList());
            buyer.setAmount(buyer.getAmount() - totalPrice);
            buyerRepository.save(buyer);
            Reciept reciept = new Reciept();
            reciept.setOrders(savedOrders);
            clearShoppingCart(id);
            return recieptRepository.save(reciept);
        }
        return null;
    }
}

