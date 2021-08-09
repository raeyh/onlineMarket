package com.suk.market.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private String description;
    @ManyToOne
    private Seller seller;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinTable
    private List<Order> orders;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
