package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class UserHasNotLoanException extends Exception {

    private static final String ERROR_MESSAGE = "User has Not loan: {0}";

    public UserHasNotLoanException(Long document) {
        super(MessageFormat.format(ERROR_MESSAGE, document));
    }
}
