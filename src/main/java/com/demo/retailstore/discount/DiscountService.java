package com.demo.retailstore.discount;


import com.demo.retailstore.user.data.UserType;

import java.math.BigDecimal;

public interface DiscountService {
    BigDecimal calculateDiscount(BigDecimal purchaseAmount);
    UserType getUserType();
}
