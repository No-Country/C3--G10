package com.nocountry.grupo10.DTO.Request;

import javax.validation.constraints.NotNull;

public class TransferRequest {
    
    @NotNull(message = "Amount can not be null.")
    private long amount;
    
    @NotNull(message = "Cvu Receiver can not be null.")
    private long cvuToSend;
    
    @NotNull(message = "Account belong can not be null.")
    private TransferIdAccountRequest accountBelong;

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getCvuReceiver() {
        return cvuToSend;
    }

    public void setCvuReceiver(long cvuReceiver) {
        this.cvuToSend = cvuReceiver;
    }

    public TransferIdAccountRequest getAccountBelong() {
        return accountBelong;
    }

    public void setAccountBelong(TransferIdAccountRequest accountBelong) {
        this.accountBelong = accountBelong;
    }
}
