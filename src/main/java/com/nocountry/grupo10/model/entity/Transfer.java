package com.nocountry.grupo10.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

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
    
    //Cvu al que se envía la transferencia
    @Column(name = "cvuReceiver")
    private long cvuReceiver;
    
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Account accountBelong;
    
    @Column(name = "timestamp")
    private Timestamp timestamp;
    
    @Column(name = "soft_delete")
    private boolean softDelete;

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
    
    public Account getAccountBelong() {
        return accountBelong;
    }

    public void setAccountBelong(Account accountBelong) {
        this.accountBelong = accountBelong;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(boolean softDelete) {
        this.softDelete = softDelete;
    }
}
