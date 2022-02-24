package com.nocountry.grupo10.service;

import com.nocountry.grupo10.DTO.Request.CardRequest;
import com.nocountry.grupo10.DTO.Response.ListCardResponse;
import com.nocountry.grupo10.exception.custom.CardAlreadyExistException;

public interface ICardService {
    
    void create(CardRequest cardRequest) throws CardAlreadyExistException;
    
    ListCardResponse listCards();
    
    void delete(Long id);
}
