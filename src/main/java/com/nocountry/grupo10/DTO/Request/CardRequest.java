package com.nocountry.grupo10.DTO.Request;

import com.nocountry.grupo10.model.entity.CardType;
import javax.validation.constraints.NotNull;

public class CardRequest {

    //@NotEmpty(message = "Card number cannot be empty")
    @NotNull(message = "Card number cannot be null.")
    private long cardNumber;
    
    //@NotEmpty(message = "Security number cannot be empty")
    @NotNull(message = "Security number cannot be null.")
    private long securityNumber;
    
    //@NotEmpty(message = "Owner name cannot be empty")
    @NotNull(message = "Owner name cannot be null.")
    private String ownerName;
    
    //@NotEmpty(message = "Type cannot be empty")
    @NotNull(message = "Type cannot be null.")
    private CardType type;
    
    @NotNull(message = "Institution cannot be null")
    private String institution;
    /*
    @NotEmpty(message = "Account cannot be empty")
    private Account account;
    */

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public long getSecurityNumber() {
        return securityNumber;
    }

    public void setSecurityNumber(long securityNumber) {
        this.securityNumber = securityNumber;
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

    /*
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    */
}
