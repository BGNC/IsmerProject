package com.bgnc.ismerproject.controller.impl;

import com.bgnc.ismerproject.controller.IBarkodController;
import com.bgnc.ismerproject.controller.RestBaseController;
import com.bgnc.ismerproject.controller.RootEntity;
import com.bgnc.ismerproject.dto.BarkodRequest;
import com.bgnc.ismerproject.dto.BarkodResponse;
import com.bgnc.ismerproject.exception.BaseException;
import com.bgnc.ismerproject.exception.ErrorMessage;
import com.bgnc.ismerproject.exception.MessageType;
import com.bgnc.ismerproject.service.IBarkodService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/barkod")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class BarkodControllerImpl extends RestBaseController implements IBarkodController {

    private static final String BARCODE_NOT_FOUND = "Barcode not found.";
    private static final String INVALID_BARCODE = "Barcode number cannot be null or empty.";

    private final IBarkodService barkodService;

    @PostMapping("/save")
    @Override
    public RootEntity<BarkodResponse> saveBarkod(@Valid @RequestBody BarkodRequest barkodRequest) {
        return ok(barkodService.saveBarkod(barkodRequest));
    }

    @GetMapping("/all-barkod")
    @Override
    public RootEntity<List<BarkodResponse>> getAllBarkod() {
        return ok(barkodService.getAllBarkod());
    }

    @GetMapping("/barkod-by-barkod-no/{barkodNo}")
    @Override
    public RootEntity<BarkodResponse> getBarkodByBarkodNo(@PathVariable(value = "barkodNo") @NotBlank String barkodNo) {

        return Optional.ofNullable(barkodService.getBarkodByBarkodNo(barkodNo))
                .map(this::ok)
                .orElseThrow(() -> new BaseException(new ErrorMessage<>(MessageType.NOT_FOUND, BARCODE_NOT_FOUND)));
    }

    @DeleteMapping("/delete-barkod/{barkodNo}")
    @Override
    public void deleteBarkod(@PathVariable(value = "barkodNo") @NotBlank String barkodNo) {

         barkodService.deleteBarkod(barkodNo);
    }

    @PutMapping("/update-barkod/{barkodNo}")
    @Override
    public RootEntity<BarkodResponse> updateBarkod( @PathVariable(value = "barkodNo")  String barkodNo ,  @Valid @RequestBody BarkodRequest barkodRequest) {
        if(barkodNo==null){
            throw new BaseException(new ErrorMessage<>(MessageType.GENERAL_EXCEPTION, null));
        }
        return ok(barkodService.updateBarkod(barkodNo,barkodRequest));
    }


}
