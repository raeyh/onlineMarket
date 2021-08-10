package com.suk.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    @ManyToOne
    private Buyer buyer;
    private boolean isApproved;
    @ManyToOne
    private Product product;
}
