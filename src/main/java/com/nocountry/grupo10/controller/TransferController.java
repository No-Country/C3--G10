package com.nocountry.grupo10.controller;

import com.nocountry.grupo10.DTO.Request.TransferRequest;
import com.nocountry.grupo10.exception.custom.MoneyNotEnoughException;
import com.nocountry.grupo10.service.ITransferService;
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

@RestController
@RequestMapping("/transfers")
public class TransferController {
    
    @Autowired
    private ITransferService transferService;
    
    @PostMapping(
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE
                )
    public ResponseEntity<?> create(@Valid @RequestBody TransferRequest request) throws MoneyNotEnoughException{
        transferService.create(request);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }
    
    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> delete(@PathVariable("id") Long idTransfer) {
		transferService.delete(idTransfer);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
        
    // To Do: GetMapping con las relaciones
}
