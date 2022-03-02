package com.nocountry.grupo10.controller;



import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.exception.custom.AccountAlreadyExistException;

import com.nocountry.grupo10.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> create(@Valid @RequestBody AccountRequest accountRequest)throws AccountAlreadyExistException {
        accountService.create(accountRequest);
        return new ResponseEntity<>(accountRequest, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAccounts() {
        return new ResponseEntity<>(accountService.listAccounts(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        accountService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
