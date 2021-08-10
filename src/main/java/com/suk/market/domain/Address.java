package com.suk.market.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    @Enumerated(EnumType.ORDINAL)
    private AddressType addressType;
    @ManyToOne
    private Buyer buyer;
}
