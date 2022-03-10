package com.nocountry.grupo10.service;

import com.nocountry.grupo10.model.entity.Account;
import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Response.ListAccountResponse;
import com.nocountry.grupo10.exception.custom.AccountAlreadyExistException;

public interface IAccountService {

    void create(AccountRequest cardRequest) throws AccountAlreadyExistException;

    ListAccountResponse listAccounts();

    void delete(Long id);
    
    Account getAccountByCvu(Long cvu);
    
    void addTransfer(Long cvu, Double amount);
}
