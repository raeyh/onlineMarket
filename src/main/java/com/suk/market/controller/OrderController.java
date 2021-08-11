package com.suk.market.controller;

import com.suk.market.domain.Order;
import com.suk.market.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PutMapping("/{id}/ship")
    public Order ship(@PathVariable Long id) {
        return orderService.ship(id);
    }


    @PutMapping("/{id}/deliver")
    public Order deliver(@PathVariable long orderId) {
        return orderService.deliver(orderId);
    }

    @PutMapping("/{id}/cancel")
    public Order cancel(@PathVariable long orderId) {
        return orderService.cancel(orderId);
    }
}
