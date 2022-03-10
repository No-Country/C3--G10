package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class CvuNotFoundException extends Exception {

    private static final String ERROR_MESSAGE = "This cvu: {0} does not exist.";
    
    public CvuNotFoundException(String cvu) {
        super(MessageFormat.format(ERROR_MESSAGE, cvu));
    }
}
