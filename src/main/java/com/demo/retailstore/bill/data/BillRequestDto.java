package com.demo.retailstore.bill.data;


import lombok.Data;

import java.util.List;

@Data
public class BillRequestDto {
    private Long userId;
    private List<Long> productIds;
}
