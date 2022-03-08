package com.nocountry.grupo10.controller;


import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;
import com.nocountry.grupo10.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;


    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LoanResponse> evaluateLoan( @RequestBody LoanRequest loanRequest) {
        LoanResponse response = loanService.createLoan(loanRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
