package com.nocountry.grupo10.DTO.Request;

import com.nocountry.grupo10.model.entity.AccountType;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AccountRequest {

    @NotNull(message = "Account number cannot be null.")
    private long AccountNumber;

    @NotNull(message = "Type cannot be null.")
    private AccountType type;

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
