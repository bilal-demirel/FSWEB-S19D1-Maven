package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Vegetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="is_grown_on_tree")
    private boolean isGrownOnTree;
}
