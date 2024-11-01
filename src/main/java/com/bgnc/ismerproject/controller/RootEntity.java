package com.bgnc.ismerproject.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RootEntity<T> {
    private T payload;
    private String errorMessage;
    private Integer status;

    public static <T> RootEntity<T> ok(T payload){
        RootEntity rootEntity = new RootEntity();
        rootEntity.setPayload(payload);
        rootEntity.setStatus(HttpStatus.OK.value());
        rootEntity.setErrorMessage(null);
        return rootEntity;
    }

    public static <T> RootEntity<T> error(String errorMessage){
        RootEntity rootEntity = new RootEntity();
        rootEntity.setPayload(null);
        rootEntity.setStatus(HttpStatus.BAD_REQUEST.value());
        rootEntity.setErrorMessage(errorMessage);
        return rootEntity;
    }
}
