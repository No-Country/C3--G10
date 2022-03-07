package com.nocountry.grupo10.service.impl;

import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Response.AccountResponse;
import com.nocountry.grupo10.DTO.Response.AppUserResponse;
import com.nocountry.grupo10.DTO.Response.ListAccountResponse;
import com.nocountry.grupo10.exception.custom.AccountAlreadyExistException;
import com.nocountry.grupo10.model.entity.Account;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.repository.AccountRepository;
import com.nocountry.grupo10.service.AccountService;
import com.nocountry.grupo10.service.UserService;
import com.nocountry.grupo10.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String ACCOUNT_ID_NOT_FOUND = "Account ID: {0} not found.";

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private UserService userService;

    @Override
    public void create(AccountRequest accountRequest) throws AccountAlreadyExistException {

        Long accountNumber;
        Long cvuNumber;
        
        AppUser user = userService.getUser(accountRequest.getUser().getIdUser());
        
        do {
            //Genero un número aleatorio y no sale hasta que ese número sea uno que no exista en la BD
            accountNumber = generateAccountNumber();
        } while(accountRepository.existsByAccountNumber(accountNumber));
        
        do {
            //Genero un número aleatorio y no sale hasta que ese número sea uno que no exista en la BD
            cvuNumber = generateCvuNumber();
        } while(accountRepository.existsByCvu(cvuNumber));
        
        Account account = ConvertUtil.convertToEntity(accountRequest);
        
        account.setAccountNumber(accountNumber);
        account.setCvu(cvuNumber);
        account.setUser(user);
        account.setSoftDelete(false);

        accountRepository.save(account);
    }

    @Override
    public ListAccountResponse listAccounts() {
        List<Account> accounts = accountRepository.findBySoftDeleteIsNullOrSoftDeleteIsFalse();

        ListAccountResponse response = new ListAccountResponse();

        if(accounts.isEmpty()) {
            return response;
        }

        List<AccountResponse> accountsResponses = new ArrayList<>();
             for(Account account: accounts) {
                  AccountResponse accountResponse = ConvertUtil.convertToDto(account);
                  AppUserResponse userResponse = ConvertUtil.convertToDto(account.getUser());
                  
                  accountResponse.setUserResponse(userResponse);
                  accountsResponses.add(accountResponse);
             }

             response.setAccounts(accountsResponses);
             return response;
        }

    @Override
    public void delete(Long id) throws NoSuchElementException {
        Account account = getAccount(id);
        account.setSoftDelete(true);
        accountRepository.save(account);
    }

    private Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(MessageFormat.format(ACCOUNT_ID_NOT_FOUND, id)));
    }
    
    private long generateAccountNumber() {
        // Genero un número random entre last e initial.
        Random random = new Random();
        int initial = 11111111;
        int last = 99999999;
        long number = (long) random.nextInt( last - initial + 1 ) + initial;
        return number;
    }
    
    private Long generateCvuNumber() {
        // Genero un número random entre last e initial.
        Random random = new Random();
        int initial = 111111111;
        int last = 999999999;
        long cvu = (long) random.nextInt( last - initial + 1 ) + initial;
        return cvu;
    }
}
