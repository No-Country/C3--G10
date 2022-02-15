package com.nocountry.grupo10.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class Card implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(unique = true, name = "id_card")
        private Long idCard;
	
	@Column(nullable = false, name = "card_number")
	private long cardNumber;
	
	@Column(nullable = false, name = "security_number")
	private long securityNumber;
	
	@Column(nullable = false, name = "owner")
	private String ownerName;
	
	@Column(nullable = false, name = "institution") //VISA, MASTERCARD,ETC
	private String institution;
	
	@Column(nullable = false, name = "card_type")	//CREDITO, DEBITO
	private CardType type;
	
	public Card() {
		
	}

	public Long getIdCard() {
		return idCard;
	}

	public void setIdCard(Long idCard) {
		this.idCard = idCard;
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

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public CardType getType() {
		return type;
	}

	public void setType(CardType type) {
		this.type = type;
	}
}
