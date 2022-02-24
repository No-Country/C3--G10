package com.nocountry.grupo10.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
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

    @Column(name = "account_maintenance")
    private Double account_Maintenance;

    @Column(name = "balance")
    private Double balance;

    @Column(nullable = false, name = "account_type")	//CAJA DE AHORRO, CUENTA CORRIENTE, CAJA DE AHORRO EN DOLARES
    private AccountType type;

    @Column(nullable = false, name = "user")
    private AppUser user;
    
    @OneToMany( mappedBy = "account", cascade = CascadeType.ALL)
    private List<Card> cards;
}
