package com.nocountry.grupo10.service.impl;


import com.nocountry.grupo10.DTO.Request.LoanRequest;
import com.nocountry.grupo10.DTO.Response.LoanResponse;
import com.nocountry.grupo10.Mapper.LoanMapper;
import com.nocountry.grupo10.exception.custom.LoanAlreadyExistException;
import com.nocountry.grupo10.exception.custom.UserDocumentNotExist;
import com.nocountry.grupo10.exception.custom.UserHasNotLoanException;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.model.entity.Loan;
import com.nocountry.grupo10.repository.AppUserRepository;
import com.nocountry.grupo10.repository.LoanRepository;
import com.nocountry.grupo10.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nocountry.grupo10.service.LoanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    private LoanRepository loanRepository;
    private LoanMapper loanMapper;
    private AppUserRepository userRepository;
    private AppUserService userService;

    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper, AppUserRepository userRepository, AppUserService userService) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public LoanResponse createLoan(LoanRequest loanRequest) throws UserDocumentNotExist, LoanAlreadyExistException {

        Optional<AppUser> user = this.userRepository.findByDocument(loanRequest.getDocument());
        if(!user.isPresent()){
            throw new UserDocumentNotExist(loanRequest.getDocument());
        }
        if(user.isPresent() && !user.get().getLoan().getIdLoan().equals(null)){
            throw new LoanAlreadyExistException(loanRequest.getDocument());
        }
        Loan loan = this.loanMapper.loanRequest2Loan(loanRequest);
        Loan savedLoan = this.loanRepository.save(loan);
        userService.AddLoan(loanRequest.getDocument(),savedLoan);
        LoanResponse response = this.loanMapper.loan2LoanResponse(savedLoan);
        return response;
    }


    @Override
    public List<LoanResponse> findAllNotAproved(){
        List<Loan> loansNotAproved = loanRepository.findAllByStateFalse();
        List<LoanResponse> loansResponseNotAproved = new ArrayList<>();
        for(Loan loan: loansNotAproved){
            loansResponseNotAproved.add(loanMapper.loan2LoanResponse(loan));
        }
        return loansResponseNotAproved;
    }

    @Override
    public LoanResponse approveLoan(Long document) throws UserDocumentNotExist, UserHasNotLoanException {
        Optional<AppUser> user = this.userRepository.findByDocument(document);
        if(!user.isPresent()){
            throw new UserDocumentNotExist(document);
        }
        if(user.get().getLoan() == null){
            throw new UserHasNotLoanException(document);
        }
        Loan loan = user.get().getLoan();
        loan.setState(true);
        loanRepository.save(loan);
        LoanResponse loanResponse = loanMapper.loan2LoanResponse(loan);
        return loanResponse;
    }


}
