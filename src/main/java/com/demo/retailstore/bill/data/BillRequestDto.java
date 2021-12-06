package com.demo.retailstore.bill.data;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class BillRequestDto {
    private Long userId;
    private List<Long> productIds;
}
