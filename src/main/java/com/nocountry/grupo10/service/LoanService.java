package com.nocountry.grupo10.service;

import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;

public interface LoanService {
    LoanResponse createLoan(LoanRequest loanRequest);
}
