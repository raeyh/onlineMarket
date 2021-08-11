package com.suk.market.service.order;

import com.suk.market.domain.Order;
import com.suk.market.domain.OrderStatus;
import com.suk.market.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order ship(Long id) {
        Order order = orderRepository.findById(id).get();
        if (order.getStatus() == OrderStatus.ORDERED) {
            order.setStatus(OrderStatus.SHIPPED);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order deliver(Long id) {
        Order order = orderRepository.findById(id).get();
        if (order.getStatus() == OrderStatus.SHIPPED) {
            order.setStatus(OrderStatus.DELIVERED);
        }
        return orderRepository.save(order);
    }

    @Override
    public Order cancel(Long id) {
        Order order = orderRepository.findById(id).get();
        if (order.getStatus() == OrderStatus.ORDERED) {
            order.setStatus(OrderStatus.CANCELLED);
        }
        return orderRepository.save(order);
    }
}
