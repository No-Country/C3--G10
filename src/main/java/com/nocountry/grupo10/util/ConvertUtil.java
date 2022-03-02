package com.nocountry.grupo10.util;

import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Response.CardResponse;
import com.nocountry.grupo10.model.entity.Card;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class ConvertUtil {
    
    private static ModelMapper modelMapper;
    
    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        ConvertUtil.modelMapper = modelMapper;
    }
    
    public static Card convertToEntity(AccountRequest request) {
        return map(request, Card.class);
    }
    
    public static CardResponse convertToDto(Card card) {
        return map(card, CardResponse.class);
    }

    private static <D> D map(Object source, Class<D> destinationType) {
        if (source == null) {
            return null;
        }

        return modelMapper.map(source, destinationType);
    }
}
