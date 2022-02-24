package com.nocountry.grupo10.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "transfer")
public class Transfer implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transfer")
    private Long idTransfer;
    
    @Column(name = "amount")
    private long amount;
    
    @Column(name = "cvuReceiver")
    private long cvuReceiver;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    public Long getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(Long idTransfer) {
        this.idTransfer = idTransfer;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getCvuReceiver() {
        return cvuReceiver;
    }

    public void setCvuReceiver(long cvuReceiver) {
        this.cvuReceiver = cvuReceiver;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }    
}
