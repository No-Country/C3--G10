package com.nocountry.grupo10.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.nocountry.grupo10.model.entity.CardType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardResponse {
    
    private Long idCard;
    
    private String ownerName;
    
    private CardType type;
    
    private String institution;

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
}
