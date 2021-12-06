package com.demo.retailstore.bill;


import com.demo.retailstore.bill.data.BillRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/bill")
public class CalculateBillApi {
    private final CalculateBillService calculateBillService;

    @PostMapping(value = "/calculate",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BigDecimal> calculate(@RequestBody BillRequestDto billRequestDto){
        log.info("Calculating the bill ...");
        return new ResponseEntity<>(calculateBillService.calculate(billRequestDto), HttpStatus.OK);
    }
}
