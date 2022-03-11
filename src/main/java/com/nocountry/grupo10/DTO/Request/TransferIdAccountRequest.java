package com.nocountry.grupo10.DTO.Request;

import javax.validation.constraints.NotNull;

public class TransferIdAccountRequest {
    /*
        Utilizo esta clase para pedir sólo el cvu de la cuenta (Account)
    a la que pertenece la transferencia
    */
    @NotNull(message = "Cvu cannot be null.")
    private Long cvu;

    public Long getCvu() {
        return cvu;
    }

    public void setCvu(Long cvu) {
        this.cvu = cvu;
    }
}
