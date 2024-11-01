package com.bgnc.ismerproject.service;

import com.bgnc.ismerproject.dto.BarkodRequest;
import com.bgnc.ismerproject.dto.BarkodResponse;

import java.util.List;

public interface IBarkodService {

    BarkodResponse saveBarkod(BarkodRequest barkodRequest);
    List<BarkodResponse> getAllBarkod();
    BarkodResponse getBarkodByBarkodNo(String barkodNo);
    void deleteBarkod(String barkodNo);
    BarkodResponse updateBarkod(String barkodNo,BarkodRequest barkodRequest);
}
