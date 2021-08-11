package com.suk.market.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

}
