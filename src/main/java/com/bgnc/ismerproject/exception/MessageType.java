package com.bgnc.ismerproject.exception;

import lombok.Getter;

@Getter
public enum MessageType {

    NO_RECORD_EXISTS("1001", "The record is not found"),
    CLIENT_ERROR("1009", "A client error occurred (4xx)"),
    SERVER_ERROR("1010", "A server error occurred (5xx)"),
    GENERAL_EXCEPTION("9999", "The general error."),

    RECORD_ALREADY_EXISTS("1011","The record already exists"),
    NOT_FOUND("1012","The record is not found" );

    private String code;
    private String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
