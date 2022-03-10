package com.nocountry.grupo10.controller;


import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;
import com.nocountry.grupo10.DTO.Response.LoanStateResponse;
import com.nocountry.grupo10.exception.custom.LoanAlreadyExistException;
import com.nocountry.grupo10.exception.custom.LoanStillNotApprobedException;
import com.nocountry.grupo10.exception.custom.UserDocumentNotExist;
import com.nocountry.grupo10.exception.custom.UserHasNotLoanException;
import com.nocountry.grupo10.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    //Pido un prestamo que se debe evaluar.
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LoanResponse> evaluateLoan( @RequestBody LoanRequest loanRequest) throws UserDocumentNotExist, LoanAlreadyExistException {
        LoanResponse response = loanService.createLoan(loanRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/state/{document}/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LoanStateResponse> loanStatus(@PathVariable Long document) throws UserHasNotLoanException, UserDocumentNotExist {
        LoanStateResponse stateResponse = this.loanService.checkLoanState(document);
        return ResponseEntity.status(HttpStatus.OK).body(stateResponse);
    }

    @PutMapping("/pay/{document}/")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<LoanResponse> payFee(@PathVariable Long document) throws UserHasNotLoanException, UserDocumentNotExist, LoanStillNotApprobedException {
        LoanResponse loanResponse = this.loanService.payLoan(document);
        return ResponseEntity.status(HttpStatus.OK).body(loanResponse);
    }

    //Obtengo todos los Loans no aprobados
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<LoanResponse>> getAllNotApproved(){
        List<LoanResponse> loansNotApproved = this.loanService.findAllNotAproved();
        return ResponseEntity.status(HttpStatus.OK).body(loansNotApproved);
    }

    @PutMapping("/{document}/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<LoanResponse> approveLoan(@PathVariable Long document) throws UserHasNotLoanException, UserDocumentNotExist {
        LoanResponse loanResponse = this.loanService.approveLoan(document);
        return ResponseEntity.status(HttpStatus.OK).body(loanResponse);
    }
}
