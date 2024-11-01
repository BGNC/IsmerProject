package com.bgnc.ismerproject.controller;

import com.bgnc.ismerproject.dto.BarkodRequest;
import com.bgnc.ismerproject.dto.BarkodResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public interface IBarkodController {

    RootEntity<BarkodResponse> saveBarkod(@Valid BarkodRequest barkodRequest);
    RootEntity<List<BarkodResponse>> getAllBarkod();
    RootEntity<BarkodResponse> getBarkodByBarkodNo(@NotBlank String barkodNo);
    void deleteBarkod(@NotBlank String barkodNo);
    RootEntity<BarkodResponse> updateBarkod(String barkodNo,@Valid BarkodRequest barkodRequest);
}
