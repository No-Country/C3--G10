package com.nocountry.grupo10.service.impl;

import com.nocountry.grupo10.model.entity.Card;
import com.nocountry.grupo10.util.ConvertUtil;
import com.nocountry.grupo10.DTO.Request.CardRequest;
import com.nocountry.grupo10.DTO.Response.CardResponse;
import com.nocountry.grupo10.DTO.Response.ListCardResponse;
import com.nocountry.grupo10.exception.custom.CardAlreadyExistException;
import com.nocountry.grupo10.repository.ICardRepository;
import com.nocountry.grupo10.service.ICardService;
import java.text.MessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
public class CardServiceImpl implements ICardService {
    
    private static final String CATEGORY_ID_NOT_FOUND = "Card ID: {0} not found.";

    @Autowired
    private ICardRepository cardRepository;

    @Override
    public void create(CardRequest cardRequest)throws CardAlreadyExistException {
        if(cardRepository.existsByCardNumber(cardRequest.getCardNumber())) {
            String card = String.valueOf(cardRequest.getCardNumber());
            throw new CardAlreadyExistException(card);
        }
        
        Card card = ConvertUtil.convertToEntity(cardRequest);
        card.setSoftDelete(false);
        
        cardRepository.save(card);
    }
    
    @Override
    public ListCardResponse listCards() {
        List<Card> cards = cardRepository.findBySoftDeleteIsNullOrSoftDeleteIsFalse();
        
        ListCardResponse response = new ListCardResponse();
        
        if(cards.isEmpty()) {
            return response;
        }
        
        List<CardResponse> cardsResponses = new ArrayList<>();
        for(Card card: cards) {
            CardResponse cardResponse = ConvertUtil.convertToDto(card);
            cardsResponses.add(cardResponse);
        }
        
        response.setCards(cardsResponses);
        return response;
    }
    
    @Override
    public void delete(Long id) throws NoSuchElementException {
        Card card = getCard(id);
        card.setSoftDelete(true);
        cardRepository.save(card);
    }
    
    private Card getCard(Long id) {
        return cardRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(MessageFormat.format(CATEGORY_ID_NOT_FOUND, id)));
    }
}
