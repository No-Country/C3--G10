package com.nocountry.grupo10.service.impl;

import com.nocountry.grupo10.DTO.Request.AccountRequest;
import com.nocountry.grupo10.DTO.Request.FixedTermAccount;
import com.nocountry.grupo10.model.entity.AppUser;
import com.nocountry.grupo10.repository.FixedTermAccountRepository;
import com.nocountry.grupo10.service.FixedTermAccountInterface;
import com.nocountry.grupo10.util.UtilConvert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FixedTermAccountImpl implements FixedTermAccountInterface {

	private static final Logger LOGGER = LoggerFactory.getLogger(FixedTermAccountImpl.class);

	@Autowired
	FixedTermAccountRepository repo;

	@Autowired
	UtilConvert convert;

	@Autowired
	AppUser client;

	@Override
	public FixedTermAccount findAll() {
		return (FixedTermAccount) repo.findAll();
	}

	public FixedTermAccount findById(String id) {
		return (FixedTermAccount) repo.findById(id);
	}

	//@Override
	//public FixedTermAccount save(Account accountDto) {

	//	return repo.findByDniAndNameBank(dni, nameBank).findByDniAndNameBank(accountDto.getNumDoc(), accountDto.getNameBank()).count().flatMap(AccountCant->{
	//		LOGGER.info("Cantidad cuentas por dni/banco: "+AccountCant);
	//		if(AccountCant==0) return repo.save(convert.convertAccountDto(accountDto));
	//		  else return Mono.empty();
        //  });
	//	});
 // }

	//@Override
	//public FixedTermAccount update(FixedTermAccount FixedTermAccount, Long id) {

         //   FixedTermAccount s = new FixedTermAccount
         //           
	//		s.setNameAccount(FixedTermAccount.getNameAccount());
	//		s.setNumberAccount(FixedTermAccount.getNumberAccount());
	//		s.setBalance(FixedTermAccount.getBalance());
	//		s.setState(FixedTermAccount.getState());
	//		s.setTea(FixedTermAccount.getTea());
	//		s.setHeadlines(FixedTermAccount.getHeadlines());
	//		s.setUpdateDate(new Date());
//
//			return repo.save(s);
//		});
//	}


	public FixedTermAccount findByNumAccount(String numberAccount) {
		return repo.findByNumberAccount(numberAccount);
	}

	public FixedTermAccount findByDni(String dni) {
		return repo.findByDni(dni);
	}

    @Override
    public FixedTermAccount findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FixedTermAccount save(AccountRequest accountDto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FixedTermAccount update(FixedTermAccount FixedTermAccount, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Void delete(FixedTermAccount FixedTermAccount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FixedTermAccount findByNumAccount(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FixedTermAccount findByDni(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FixedTermAccount toList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}