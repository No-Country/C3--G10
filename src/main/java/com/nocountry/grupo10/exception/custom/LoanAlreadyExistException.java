package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class LoanAlreadyExistException extends Exception {

    private static final String ERROR_MESSAGE = "User already has a Loan Not : {0}";

    public LoanAlreadyExistException(Long document) {
        super(MessageFormat.format(ERROR_MESSAGE, document));
    }
}
