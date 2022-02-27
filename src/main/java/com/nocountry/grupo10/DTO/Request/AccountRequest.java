package com.nocountry.grupo10.DTO.Request;

import javax.validation.constraints.NotNull;

public class AccountRequest {

    @NotNull(message = "Balance can not be null.")
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
    
    //To Do: agregar todos los atributos necesarios
}
