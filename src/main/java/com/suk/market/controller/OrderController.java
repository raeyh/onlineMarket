package com.suk.market.controller;

import com.suk.market.domain.Order;
import com.suk.market.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PutMapping("/orders/{id}/ship")
    public Order ship(@PathVariable Long id) {
        return orderService.ship(id);
    }


    @PutMapping("/orders/{id}/deliver") // cancel Order
    public Order deliver(@PathVariable long orderId) {
        return orderService.deliver(orderId);
    }

    @PutMapping("/orders/{id}/cancel") // cancel Order
    public Order cancel(@PathVariable long orderId) {
        return orderService.cancel(orderId);
    }
}
