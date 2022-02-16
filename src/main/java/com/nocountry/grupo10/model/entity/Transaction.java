package com.nocountry.grupo10.model.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table (name = "Transaction")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
}
