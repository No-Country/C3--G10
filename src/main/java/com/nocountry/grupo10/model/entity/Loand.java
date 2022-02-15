package com.nocountry.grupo10.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Loands")
@Data
public class Loand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}
