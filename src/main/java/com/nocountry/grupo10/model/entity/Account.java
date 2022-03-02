package com.nocountry.grupo10.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Entity
@Table (name= "account")
@Data
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id_account")
    private Long idAccount;

    @Column(nullable = false, name = "account_number")
    private long AccountNumber;

    @Column(name = "account_maintenance")
    private Double account_Maintenance;

    @Column(name = "balance")
    private Double balance;

    //@Column(nullable = false, name = "account_type")	//CAJA DE AHORRO, CUENTA CORRIENTE, CAJA DE AHORRO EN DOLARES
    @Column(name = "account_type")
    private AccountType type;

    @Column(nullable = false, name = "user")
    @ManyToOne(fetch = FetchType.LAZY)
    private AppUser user;
    
    @OneToMany( mappedBy = "account", cascade = CascadeType.ALL)
    private List<Card> cards;

    @Column(name = "soft_delete")
    private boolean softDelete;
    
    @OneToMany(mappedBy = "accountBelong", cascade = CascadeType.ALL)
    private List<Transfer> transfers;
}
