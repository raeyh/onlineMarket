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
    private double amount;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Address> addresses;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable
    private List<Seller> sellers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> reviews;
}
