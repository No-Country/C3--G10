package com.nocountry.grupo10.DTO.Response;

import java.util.List;

public class ListCardResponse {

    private List<CardResponse> cards;
    
    public ListCardResponse() {
    
    }
    
    public void setCards(List<CardResponse> cards) {
        this.cards = cards;
    }
    
    public List<CardResponse> getCards() {
        return this. cards;
    }
}
