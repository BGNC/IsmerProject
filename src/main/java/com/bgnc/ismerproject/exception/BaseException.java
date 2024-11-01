package com.bgnc.ismerproject.exception;

public class BaseException extends RuntimeException {
    public BaseException(ErrorMessage message) {
        super(message.prepareMessage());
    }
}
