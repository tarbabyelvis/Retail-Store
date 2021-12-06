package com.demo.retailstore.bill;

import com.demo.retailstore.bill.data.BillRequestDto;

import java.math.BigDecimal;

public interface CalculateBillService {
    BigDecimal calculate(BillRequestDto billRequestDto);
}
