package com.nocountry.grupo10.controller;

import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Response.DeleteOkResponse;
import com.nocountry.grupo10.exception.custom.AccountAlreadyExistException;
import com.nocountry.grupo10.exception.custom.CvuNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.nocountry.grupo10.exception.custom.ExceptionHandler;
import javax.validation.Valid;
import com.nocountry.grupo10.service.IAccountService;
import java.util.NoSuchElementException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> create(@Valid @RequestBody AccountRequest accountRequest)
            throws AccountAlreadyExistException {
        accountService.create(accountRequest);
        return new ResponseEntity<>(accountRequest, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAccounts() {
        return new ResponseEntity<>(accountService.listAccounts(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        try {
            accountService.delete(id);
            return DeleteOkResponse.deleteOk(id);
        } catch (NoSuchElementException e) {
            return ExceptionHandler.throwError(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
