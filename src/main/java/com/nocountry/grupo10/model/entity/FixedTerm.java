package com.nocountry.grupo10.model.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table (name= "fixedTerm")
@Data
public class FixedTerm implements Serializable{
    
     private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, name = "id_account")
    private Long idFixedTerm;
    
    @Column(name = "capital")
    private Double Capital;
    
    @Column(name = "term")
    private Double Term;
    
    @Column(name = "numberAccount")
    private List<Account> numberAccount;

    @Column(name = "tea")
    private Double tea;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "balance")
    private Double balance;
    
    @Column(name = "headlines")
    private List<AppUser> headlines;
}
