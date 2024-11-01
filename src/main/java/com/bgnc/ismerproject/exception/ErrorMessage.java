package com.bgnc.ismerproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage<T> {

    private MessageType messageType;
    private String ofStatic;


    public String prepareMessage() {
        StringBuilder builder = new StringBuilder();

        builder.append(messageType.getMessage());
        if (ofStatic != null) {
            builder.append(" : ")

                    .append(ofStatic);
        }
        return builder.toString();
    }

}