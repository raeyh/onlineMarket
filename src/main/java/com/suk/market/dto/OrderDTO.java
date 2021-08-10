package com.suk.market.dto;

import com.suk.market.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Address shippingAddress;
    private Address billingAddress;
}
