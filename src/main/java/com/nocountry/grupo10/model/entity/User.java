package com.nocountry.grupo10.model.entity;

import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;
    
    @Column(name = "dni")
    private String dni;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "date_of_birth")
    private LocalDate date_of_birth;
    
    @Column(name = "username")
    private String username;
    
    @Column(name = "password")
    private String password;
}
