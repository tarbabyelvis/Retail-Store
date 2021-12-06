package com.demo.retailstore.bill;


import com.demo.retailstore.bill.data.BillRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/bill")
public class CalculateBillApi {
    private final CalculateBillService calculateBillService;

    @PostMapping("/calculate")
    @ResponseBody
    public BigDecimal calculate(@RequestBody BillRequestDto billRequestDto){

    }
}
