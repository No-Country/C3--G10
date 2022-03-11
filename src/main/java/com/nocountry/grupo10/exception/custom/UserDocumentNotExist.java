package com.nocountry.grupo10.exception.custom;

import java.text.MessageFormat;

public class UserDocumentNotExist extends Exception {

    private static final String ERROR_MESSAGE = "Document Not exist: {0}";

    public UserDocumentNotExist(Long document) {
        super(MessageFormat.format(ERROR_MESSAGE, document));
    }
}
