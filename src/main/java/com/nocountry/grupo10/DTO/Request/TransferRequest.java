package com.nocountry.grupo10.DTO.Request;

import javax.validation.constraints.NotNull;

public class TransferRequest {
    
    @NotNull(message = "Amount can not be null.")
    private Double amount;
    
    @NotNull(message = "Cvu Receiver can not be null.")
    private long cvuReceiver;
    
    @NotNull(message = "Account belong can not be null.")
    private TransferIdAccountRequest accountBelong;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public long getCvuReceiver() {
        return cvuReceiver;
    }

    public void setCvuReceiver(long cvuReceiver) {
        this.cvuReceiver = cvuReceiver;
    }

    public TransferIdAccountRequest getAccountBelong() {
        return accountBelong;
    }

    public void setAccountBelong(TransferIdAccountRequest accountBelong) {
        this.accountBelong = accountBelong;
    }
}
