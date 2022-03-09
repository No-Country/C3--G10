package com.nocountry.grupo10.DTO.Response;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteOkResponse {

    private static String message;
    
    public static ResponseEntity<?> deleteOk(Long id) {
        message = "Id: " + id + " deleted succesfully.";
        Map<String, String> body = new HashMap<>();
        body.put("message", message);
        
        return new ResponseEntity<>(body, HttpStatus.OK);
    }
}
