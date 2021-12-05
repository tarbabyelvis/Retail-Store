package com.demo.retailstore.discount;


import java.math.BigDecimal;

public interface DiscountService {
    BigDecimal calculateDiscount(BigDecimal purchaseAmount);
}
