package com.nocountry.grupo10.DTO.Request;

import com.nocountry.grupo10.model.entity.AccountType;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class AccountRequest {

    @NotNull(message = "Type cannot be null.")
    private AccountType type;

    @NotNull(message = "Balance cannot be null.")
    private Double balance;
    
    @NotNull(message = "AppUser cannot be null.")
    private AccountUserRequest user;
    
    private double account_maintenance;
    //To Do: agregar todos los atributos necesarios
}
