package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class LoanStillNotApprobedException extends Exception {

    private static final String ERROR_MESSAGE = "Loan is under review: {0}";

    public LoanStillNotApprobedException(Long document) {
        super(MessageFormat.format(ERROR_MESSAGE, document));
    }
}
