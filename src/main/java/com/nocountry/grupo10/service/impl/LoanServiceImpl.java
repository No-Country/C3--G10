package com.nocountry.grupo10.service.impl;


import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;
import com.nocountry.grupo10.Mapper.LoanMapper;
import com.nocountry.grupo10.model.entity.Loan;
import com.nocountry.grupo10.repository.AppUserRepository;
import com.nocountry.grupo10.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nocountry.grupo10.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    private LoanMapper loanMapper;
    private AppUserRepository userRepository;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper, AppUserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
        this.userRepository = userRepository;
    }

    @Override
    public LoanResponse createLoan(LoanRequest loanRequest) {
        if(!userRepository.findByDocument(loanRequest.getDocument()).isEmpty()){
            Loan loan = this.loanMapper.loanRequest2Loan(loanRequest);
            Loan savedLoan = this.loanRepository.save(loan);
            LoanResponse response = this.loanMapper.loan2LoanResponse(savedLoan);
            return response;
        };
    return new LoanResponse();
    }


}
