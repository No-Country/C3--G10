package com.nocountry.grupo10.service;

import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Request.FixedTermAccount;

public interface FixedTermAccountInterface {
    
    
	public FixedTermAccount findAll();
	public FixedTermAccount findById(Long id);
	public FixedTermAccount save(AccountRequest accountDto);
	public FixedTermAccount update(FixedTermAccount FixedTermAccount, Long id);
	public Void delete(FixedTermAccount FixedTermAccount);

	public FixedTermAccount findByNumAccount(Long id);
	public FixedTermAccount findByDni(Long id);
        
        public FixedTermAccount toList();
	
}
