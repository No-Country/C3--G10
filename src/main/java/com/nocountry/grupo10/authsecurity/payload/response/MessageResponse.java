package com.nocountry.grupo10.authsecurity.payload.response;

/**
 * Clase encargada de devolver un mensaje como respuesta a un request de signup o login
 * @author NoCountry-G10
 * @version 1.0
 */
public class MessageResponse {
    private String message;

    public MessageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
