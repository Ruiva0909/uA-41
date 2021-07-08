package com.prova4.ua4.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue (strategy =  GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_store", referencedColumnName = "id")
    private Store store;
}
