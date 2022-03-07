package com.nocountry.grupo10.DTO.Request;

import javax.validation.constraints.NotNull;

public class AccountUserRequest {

    /*
        LO UTILIZO SÓLO PARA RECIBIR EL ID Y ESTABLECER LA RELACIÓN ENTRE ACCOUNT Y USER
    */
    @NotNull(message = "IdUser cannot be null.")
    private Long idUser;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
