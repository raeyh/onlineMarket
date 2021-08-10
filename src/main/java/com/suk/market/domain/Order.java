package com.suk.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ProOrder")
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    private Product product;

    @ManyToOne
    private Address shippingAddress;

    @ManyToOne
    private Address billingAddress;
}
