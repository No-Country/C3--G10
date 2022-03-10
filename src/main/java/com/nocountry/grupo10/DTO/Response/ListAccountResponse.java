package com.nocountry.grupo10.DTO.Response;

import java.util.List;

public class ListAccountResponse {

    private List<AccountResponse> accounts;

    public ListAccountResponse() {

    }
    public void setAccounts(List<AccountResponse> accounts) {
        this.accounts = accounts;
    }

    public List<AccountResponse> getAccounts() {
        return this. accounts;
    }
}
