package com.suk.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    private boolean isApproved;

    @ManyToOne
    private Product product;


}
