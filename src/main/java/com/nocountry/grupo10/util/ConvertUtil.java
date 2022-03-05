package com.nocountry.grupo10.util;

import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Request.CardRequest;
import com.nocountry.grupo10.DTO.Request.TransferRequest;
import com.nocountry.grupo10.DTO.Response.CardResponse;
import com.nocountry.grupo10.model.entity.Card;
import com.nocountry.grupo10.model.entity.Transfer;
import com.nocountry.grupo10.model.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.mappers.ModelMapper;

@Component
public class ConvertUtil {
    
    private static ModelMapper modelMapper;
    
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        ConvertUtil.modelMapper = modelMapper;
    }
    
    public static Card convertToEntity(CardRequest request) {
        return map(request, Card.class);
    }
    
    public static CardResponse convertToDto(Card card) {
        return map(card, CardResponse.class);
    }
    
    public static Transfer convertToEntity(TransferRequest request) {
        return map(request, Transfer.class);
    }
    
    public static Account convertToEntity(AccountRequest request) {
        return map(request, Account.class);
    }

    private static <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }

        return map(source, destinationType);
    }
}
