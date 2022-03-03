package com.nocountry.grupo10.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "account")
@Data
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id_account")
    private Long idAccount;

    @Column(nullable = false, unique = true, name = "account_number")
    private long AccountNumber;

    @Column(name = "account_maintenance")
    private Double account_Maintenance;

    @Column(name = "balance")
    private Double balance;

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
    
    @Column(name = "cvu", nullable = false)
    private long cvu;
}
