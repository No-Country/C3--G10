package com.nocountry.grupo10.controller;

import com.nocountry.grupo10.DTO.Request.CardRequest;
import com.nocountry.grupo10.DTO.Response.DeleteOkResponse;
import com.nocountry.grupo10.exception.custom.CardAlreadyExistException;
import com.nocountry.grupo10.exception.custom.ExceptionHandler;
import com.nocountry.grupo10.service.ICardService;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
    
    @Autowired
    private ICardService cardService;
    
    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
                )
    public ResponseEntity<?> create(@Valid @RequestBody CardRequest cardRequest)throws CardAlreadyExistException {
        cardService.create(cardRequest);
        return new ResponseEntity<>(cardRequest, HttpStatus.CREATED);
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listCards() {
        return new ResponseEntity<>(cardService.listCards(), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            cardService.delete(id);
            return DeleteOkResponse.deleteOk(id);
        } catch (NoSuchElementException e) {
            return ExceptionHandler.throwError(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
