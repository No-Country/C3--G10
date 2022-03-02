package com.nocountry.grupo10.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.nocountry.grupo10.model.entity.AccountType;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse {

    //private long AccountNumber;

    private AccountType type;

    private Double balance;

}
