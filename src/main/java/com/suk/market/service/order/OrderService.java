package com.suk.market.service.order;

import com.suk.market.domain.Order;

public interface OrderService {
    Order ship(Long id);

    Order deliver(Long id);

    Order cancel(Long id);

}
