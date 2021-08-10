package com.suk.market.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reciept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    List<Order> orders;
}
