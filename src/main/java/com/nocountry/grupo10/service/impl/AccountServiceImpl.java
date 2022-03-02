package com.nocountry.grupo10.service.impl;



import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Response.AccountResponse;
import com.nocountry.grupo10.DTO.Response.ListAccountResponse;
import com.nocountry.grupo10.exception.custom.AccountAlreadyExistException;

import com.nocountry.grupo10.model.entity.Account;



import com.nocountry.grupo10.repository.AccountRepository;

import com.nocountry.grupo10.service.AccountService;
import com.nocountry.grupo10.util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountServiceImpl implements AccountService {

    private static final String CATEGORY_ID_NOT_FOUND = "Account ID: {0} not found.";

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void create(AccountRequest accountRequest) throws AccountAlreadyExistException {

        if(accountRepository.existsByAccountNumber(accountRequest.getAccountNumber())) {
            String account= String.valueOf(accountRequest.getAccountNumber());
            throw new AccountAlreadyExistException(account);
    }
        Account account = ConvertUtil.convertToEntity(accountRequest);
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
                  AccountResponse accountResponse =ConvertUtil.convertToDto(account); //Funciona para crear DTO?
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
                .orElseThrow(() -> new NoSuchElementException(MessageFormat.format(CATEGORY_ID_NOT_FOUND, id)));
    }
}
