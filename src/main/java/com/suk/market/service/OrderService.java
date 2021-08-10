package com.suk.market.service;

import com.suk.market.domain.Order;

public interface OrderService {
    Order ship(Long id);

    Order deliver(Long id);

    Order cancel(Long id);

}
