package com.suk.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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
    private Date issuedDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    private Product product;

    @ManyToOne
    @JoinColumn(name = "ship_address_id")
    private Address shippingAddress;

    @ManyToOne
    @JoinColumn(name = "bill_address_id")
    private Address billingAddress;
}
