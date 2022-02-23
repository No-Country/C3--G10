package com.nocountry.grupo10.authsecurity.payload.request;

import javax.validation.constraints.NotBlank;

/**
 * Request utilizado para logear una vez creado el AppUser
 * @author NoCountry-G10
 * @version 1.0
 */
public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
