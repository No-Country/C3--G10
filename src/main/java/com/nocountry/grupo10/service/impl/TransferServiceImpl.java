package com.nocountry.grupo10.service.impl;

import com.nocountry.grupo10.model.entity.Transfer;
import com.nocountry.grupo10.DTO.Request.TransferRequest;
import com.nocountry.grupo10.exception.custom.CvuNotFoundException;
import com.nocountry.grupo10.exception.custom.MoneyNotEnoughException;
import com.nocountry.grupo10.model.entity.Account;
import com.nocountry.grupo10.repository.ITransferRepository;
import com.nocountry.grupo10.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.nocountry.grupo10.service.ITransferService;
import com.nocountry.grupo10.util.ConvertUtil;
import com.nocountry.grupo10.util.TimeStampUtil;
import java.text.MessageFormat;
import java.util.NoSuchElementException;

@Service
public class TransferServiceImpl implements ITransferService {
    
    private static final String USER_ID_NOT_FOUND = "User ID: {0} not found.";
    
    @Autowired
    private ITransferRepository transferRepository;
    
    @Autowired
    private IAccountService accountService;
    
    @Override
    public void create(TransferRequest transferRequest) throws MoneyNotEnoughException, CvuNotFoundException {
        
        //Cvu al que voy a enviar la transferencia
        Long cvuReceiver = transferRequest.getCvuReceiver();
        Double amount = transferRequest.getAmount();
        
        Account accountReceiver = accountService.getAccountByCvu(cvuReceiver);
        if(accountReceiver.isSoftDelete()) {
            String cvu = String.valueOf(cvuReceiver);
            
            throw new CvuNotFoundException(cvu);
        }
        
        //Traigo la account a la que pertenece la transferencia
        Account account = accountService.getAccountByCvu(transferRequest.getAccountBelong().getCvu());
        Double balance = account.getBalance();
        
        Transfer transfer = ConvertUtil.convertToEntity(transferRequest);
        
        //Verifico que el dinero disponible en la cuanta es mayor que la cantidad que quiero enviar
        boolean moneyEnough = balance >= transferRequest.getAmount();
        
        if(!moneyEnough) {
            //Si balance es menor que la cantidad a enviar, lanzo la excepción
            String ammount = String.valueOf(transferRequest.getAmount());
            
            throw new MoneyNotEnoughException(ammount);
        }
        
        //Actualizo el balance después de enviar la transferencia
        Double balanceUpdated = balance - transferRequest.getAmount();
        account.setBalance(balanceUpdated);
        transfer.setAccountBelong(account);
        transfer.setTimestamp(TimeStampUtil.getCurrentTime());
        
        /*
            Actualiza el balance después de recibir la transferencia
            envio el cvu y la cantidad de dinero que envía
        */
        accountService.addTransfer(cvuReceiver, amount);
        transferRepository.save(transfer);
    }

    @Override
    public void delete(long id) throws NoSuchElementException {
        Transfer transfer = transferRepository.findById(id)
                .orElseThrow(
                    ()-> new NoSuchElementException(MessageFormat.format(USER_ID_NOT_FOUND, id))
                );
        
        transfer.setSoftDelete(true);
        transferRepository.save(transfer);
    }
}
