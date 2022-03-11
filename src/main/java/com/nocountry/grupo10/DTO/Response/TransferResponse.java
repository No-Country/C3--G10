package com.nocountry.grupo10.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransferResponse {
    
    private Long idTransfer;
    
    private Double amount;
    
    private Long cvuReceiver;
    
    private AccountResponse accountBelong;

    public Long getIdTransfer() {
        return idTransfer;
    }

    public void setIdTransfer(Long idTransfer) {
        this.idTransfer = idTransfer;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getCvuReceiver() {
        return cvuReceiver;
    }

    public void setCvuReceiver(Long cvuReceiver) {
        this.cvuReceiver = cvuReceiver;
    }

    public AccountResponse getAccountBelong() {
        return accountBelong;
    }

    public void setAccountBelong(AccountResponse accountBelong) {
        this.accountBelong = accountBelong;
    }
}
