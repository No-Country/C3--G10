package com.nocountry.grupo10.service;

import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;
import com.nocountry.grupo10.exception.custom.LoanAlreadyExistException;
import com.nocountry.grupo10.exception.custom.UserDocumentNotExist;
import com.nocountry.grupo10.exception.custom.UserHasNotLoanException;

import java.util.List;

public interface LoanService {
    LoanResponse createLoan(LoanRequest loanRequest) throws UserDocumentNotExist, LoanAlreadyExistException;
    List<LoanResponse> findAllNotAproved();
    LoanResponse approveLoan(Long document) throws UserDocumentNotExist, UserHasNotLoanException;
}
