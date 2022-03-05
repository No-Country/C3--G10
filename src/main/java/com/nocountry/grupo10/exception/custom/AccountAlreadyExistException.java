package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class AccountAlreadyExistException extends Exception {

    private static final String ERROR_MESSAGE = "Card already exist: {0}";

    public AccountAlreadyExistException(String name) {
        super(MessageFormat.format(ERROR_MESSAGE, name));
    }
}
