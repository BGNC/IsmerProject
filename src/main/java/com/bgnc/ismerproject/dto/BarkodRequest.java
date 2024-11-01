package com.bgnc.ismerproject.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BarkodRequest {


    @NotNull(message = "Barkod no is required field")
    private String barkodNo;
}
