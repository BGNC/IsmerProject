package com.bgnc.ismerproject.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ApiError<E> {
    private int status;

    private Exception<E> exception;

}