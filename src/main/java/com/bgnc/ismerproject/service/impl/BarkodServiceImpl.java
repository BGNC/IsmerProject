package com.bgnc.ismerproject.service.impl;

import com.bgnc.ismerproject.dto.BarkodRequest;
import com.bgnc.ismerproject.dto.BarkodResponse;
import com.bgnc.ismerproject.exception.BaseException;
import com.bgnc.ismerproject.exception.ErrorMessage;
import com.bgnc.ismerproject.exception.MessageType;
import com.bgnc.ismerproject.model.Barkod;
import com.bgnc.ismerproject.repository.BarkodRepository;
import com.bgnc.ismerproject.service.IBarkodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BarkodServiceImpl implements IBarkodService {

    private final BarkodRepository barkodRepository;

    private Barkod createBarkod(BarkodRequest barkodRequest){
        Barkod barkod = new Barkod();
        barkod.setBarkodNo(barkodRequest.getBarkodNo());
        barkod.setCreateTime(new Date());
        return barkod;
    }
    @Override
    public BarkodResponse saveBarkod(BarkodRequest barkodRequest) {
        BarkodResponse barkodResponse = new BarkodResponse();
        Barkod barkod = barkodRepository.save(createBarkod(barkodRequest));
        BeanUtils.copyProperties(barkod, barkodResponse);
        return barkodResponse;

    }

    @Override
    public List<BarkodResponse> getAllBarkod() {
        return barkodRepository.findAll().stream()
                .map(this::convertToBarkodResponse)
                .collect(Collectors.toList());
    }

    @Override
    public BarkodResponse getBarkodByBarkodNo(String barkodNo) {
        Barkod barkodByBarkodNo = barkodRepository.findByBarkodNo(barkodNo);
        if(barkodByBarkodNo == null){
            throw new BaseException(new ErrorMessage<>(MessageType.NO_RECORD_EXISTS,barkodNo));
        }

        return convertToBarkodResponse(barkodByBarkodNo);
    }

    @Override
    public void deleteBarkod(String barkodNo) {
        Barkod barkodByBarkodNo = barkodRepository.findByBarkodNo(barkodNo);
        if(barkodByBarkodNo == null){
            throw new BaseException(new ErrorMessage<>(MessageType.NO_RECORD_EXISTS,barkodNo));
        }
        barkodRepository.delete(barkodByBarkodNo);
    }

    @Override
    public BarkodResponse updateBarkod(String barkodNo, @Valid BarkodRequest barkodRequest) {
        Barkod existingBarkod = barkodRepository.findByBarkodNo(barkodNo);

        if (existingBarkod == null) {
            throw new BaseException(new ErrorMessage<>(MessageType.NO_RECORD_EXISTS, barkodNo));
        }


        if (!existingBarkod.getBarkodNo().equals(barkodRequest.getBarkodNo()) &&
                barkodRepository.findByBarkodNo(barkodRequest.getBarkodNo()) != null) {
            throw new BaseException(new ErrorMessage<>(MessageType.RECORD_ALREADY_EXISTS, barkodRequest.getBarkodNo()));
        }

        existingBarkod.setBarkodNo(barkodRequest.getBarkodNo());

        Barkod updatedBarkod = barkodRepository.save(existingBarkod);

        return convertToBarkodResponse(updatedBarkod);
    }


    private BarkodResponse convertToBarkodResponse(Barkod barkod) {
        BarkodResponse barkodResponse = new BarkodResponse();
        BeanUtils.copyProperties(barkod, barkodResponse);
        return barkodResponse;
    }


}
