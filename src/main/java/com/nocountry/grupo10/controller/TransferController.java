package com.nocountry.grupo10.controller;

import com.nocountry.grupo10.DTO.Request.TransferRequest;
import com.nocountry.grupo10.DTO.Response.DeleteOkResponse;
import com.nocountry.grupo10.exception.custom.CvuNotFoundException;
import com.nocountry.grupo10.exception.custom.MoneyNotEnoughException;
import com.nocountry.grupo10.service.ITransferService;
import java.util.NoSuchElementException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nocountry.grupo10.exception.custom.ExceptionHandler;
import com.nocountry.grupo10.exception.custom.NotSavingBankAccountException;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/transfers")
public class TransferController {

    @Autowired
    private ITransferService transferService;

    @PostMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> create(@Valid @RequestBody TransferRequest request)
            throws MoneyNotEnoughException, CvuNotFoundException, NotSavingBankAccountException {
        try {
            transferService.create(request);
            return new ResponseEntity<>(request, HttpStatus.CREATED);
        } catch (CvuNotFoundException e) {
            return ExceptionHandler.throwError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (MoneyNotEnoughException e) {
            return ExceptionHandler.throwError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (NotSavingBankAccountException e) {
            return ExceptionHandler.throwError(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
    
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> listAccounts() {
        return new ResponseEntity<>(transferService.listTransfers(), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable("id") Long idTransfer) {
        try {
            transferService.delete(idTransfer);
            return DeleteOkResponse.deleteOk(idTransfer);
        } catch (NoSuchElementException e) {
            return ExceptionHandler.throwError(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
