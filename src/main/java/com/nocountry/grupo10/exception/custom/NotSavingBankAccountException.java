package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class NotSavingBankAccountException extends Exception {
    
    private static final String ERROR_MESSAGE = "This cvu: {0} is not a SAVINGBANK account.";

    public NotSavingBankAccountException(String cvu) {
        super(MessageFormat.format(ERROR_MESSAGE, cvu));
    }
}
