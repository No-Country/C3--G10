package com.nocountry.grupo10.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;



@Entity
@Table(name = "User")
@Data
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String dni;
    private String name;
    private String lastname;
    private String phone;
    @Column(name = "date_of_birth")

    private LocalDate date_of_birth;
    private String username;
    private String password;



}
