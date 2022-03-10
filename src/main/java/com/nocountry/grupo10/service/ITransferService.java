package com.nocountry.grupo10.service;

import com.nocountry.grupo10.DTO.Request.TransferRequest;
import com.nocountry.grupo10.DTO.Response.ListTransferResponse;
import com.nocountry.grupo10.exception.custom.CvuNotFoundException;
import com.nocountry.grupo10.exception.custom.MoneyNotEnoughException;
import com.nocountry.grupo10.exception.custom.NotSavingBankAccountException;


public interface ITransferService {
    
    void create(TransferRequest transferRequest)
            throws MoneyNotEnoughException, CvuNotFoundException, NotSavingBankAccountException;
    
    void delete(long id);
    
    ListTransferResponse listTransfers();
}
