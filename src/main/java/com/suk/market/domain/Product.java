package com.suk.market.domain;

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
    private String productName;
    private double price;
    private byte[] image;
    @Column(name = "description")
    private String productDescription;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
