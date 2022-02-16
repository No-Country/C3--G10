package com.nocountry.grupo10.model.entity;


import lombok.Getter;
import lombok.Setter;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table (name= "account")
@Getter
@Setter
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id_account")
    private Long idAccount;

    @Column(name = "account_maintenance")
    private Double account_Maintenance;

    @Column(name = "balance")
    private Double balance;

    @Column(nullable = false, name = "account_type")	//CAJA DE AHORRO, CUENTA CORRIENTE, CAJA DE AHORRO EN DOLARES
    private AccountType type;

    @Column(nullable = false, name = "user")
    private User user;


}
