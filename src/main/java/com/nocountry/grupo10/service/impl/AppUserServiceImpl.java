package com.nocountry.grupo10.service.impl;

import com.nocountry.grupo10.Mapper.LoanMapper;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.model.entity.Loan;
import com.nocountry.grupo10.repository.AppUserRepository;
import com.nocountry.grupo10.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository userRepository;

    @Autowired
    private LoanMapper loanMapper;

    @Override
    public void AddLoan(Long document, Loan loan) {
        Optional<AppUser> user = userRepository.findByDocument(document);
        if(user.isPresent()){
            user.get().setLoan(loan);
            userRepository.save(user.get());
        }
    }
}
