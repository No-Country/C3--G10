package com.nocountry.grupo10.service.impl;

import com.nocountry.grupo10.model.entity.Transfer;
import com.nocountry.grupo10.DTO.Request.TransferRequest;
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
    public void create(TransferRequest transferRequest) throws MoneyNotEnoughException {
        /*
        Account account = ConvertUtil.convertToEntity(transferRequest.getAccountBelong());  //Obtengo la accountRequest para convertirla en entity
        Transfer transfer = ConvertUtil.convertToEntity(transferRequest);
        transfer.setAccountBelong(account);
        Double balance = transferRequest.getAccountBelong().getBalance();
        boolean moneyEnough = balance > transferRequest.getAmount();
        
        if(!moneyEnough) {
            String ammount = String.valueOf(transferRequest.getAmount());
            
            throw new MoneyNotEnoughException(ammount);
        }
        
        transfer.setTimestamp(TimeStampUtil.getCurrentTime());
        transferRepository.save(transfer);
*/
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
