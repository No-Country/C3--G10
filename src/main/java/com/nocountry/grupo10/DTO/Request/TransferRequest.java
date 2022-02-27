package com.nocountry.grupo10.DTO.Request;

import com.nocountry.grupo10.model.entity.Account;
import javax.validation.constraints.NotNull;

public class TransferRequest {
    
    @NotNull(message = "Amount can not be null.")
    private long amount;
    
    @NotNull(message = "Cvu Receiver can not be null.")
    private long cvuReceiver;
    
    @NotNull(message = "Account can not be null.")
    private AccountRequest accountBelong;

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

    public AccountRequest getAccountBelong() {
        return accountBelong;
    }

    public void setAccountBelong(AccountRequest accountBelong) {
        this.accountBelong = accountBelong;
    }
}
