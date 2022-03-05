package com.nocountry.grupo10.repository;

import com.nocountry.grupo10.DTO.Request.FixedTermAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FixedTermAccountRepository extends JpaRepository <FixedTermAccount, Long> {
    
    public FixedTermAccount findByNumberAccount(String numberAccount);
	 
	 @Query("{'headlines.dni': ?0 }") 
	 public FixedTermAccount findByDni(String dni);
		
	 @Query("{'headlines.dni': ?0 , 'nameBank': ?1}") 
	 public FixedTermAccount findByDniAndNameBank(String dni , String nameBank);

        public Object findById(String id);

    public FixedTermAccount save(Long id);

}