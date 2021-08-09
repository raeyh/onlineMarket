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
public class Buyer extends User {

    @OneToMany(cascade = CascadeType.ALL)
    private List<Address> addresses;
    @OneToMany(mappedBy = "buyer")
    @JsonIgnore
    private List<Order> orders;
    @OneToOne(cascade = CascadeType.ALL)
    private ShoppingCart shoppingCart;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Seller> sellers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
