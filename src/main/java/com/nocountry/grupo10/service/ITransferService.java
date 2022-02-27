package com.nocountry.grupo10.service;

import com.nocountry.grupo10.DTO.Request.TransferRequest;
import com.nocountry.grupo10.exception.custom.MoneyNotEnoughException;


public interface ITransferService {
    
    void create(TransferRequest transferRequest) throws MoneyNotEnoughException;
    
    void delete(long id);
}
