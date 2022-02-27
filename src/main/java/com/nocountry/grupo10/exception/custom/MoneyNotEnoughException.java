package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class MoneyNotEnoughException extends Exception {

    private static final String ERROR_MESSAGE = "This ammount {0} is not available in your account.";
    
    public MoneyNotEnoughException(String ammount) {
        super(MessageFormat.format(ERROR_MESSAGE, ammount));
    }
}
