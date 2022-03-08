package com.nocountry.grupo10.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.nocountry.grupo10.model.entity.AccountType;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    private long idAccount;
    
    private long accountNumber;
    
    private AccountType type;
    
    private long account_Maintenance;

    private Double balance;
    
    private AppUserResponse userResponse;

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public long getAccount_Maintenance() {
        return account_Maintenance;
    }

    public void setAccount_Maintenance(long account_Maintenance) {
        this.account_Maintenance = account_Maintenance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AppUserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(AppUserResponse userResponse) {
        this.userResponse = userResponse;
    }

    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }
}
