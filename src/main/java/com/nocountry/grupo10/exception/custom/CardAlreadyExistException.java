package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class CardAlreadyExistException extends Exception {

    private static final String ERROR_MESSAGE = "Card already exist: {0}";
    
    public CardAlreadyExistException(String name) {
        super(MessageFormat.format(ERROR_MESSAGE, name));
    }
}
