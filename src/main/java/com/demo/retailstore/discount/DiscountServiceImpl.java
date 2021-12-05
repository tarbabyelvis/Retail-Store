package com.demo.retailstore.discount;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService{
    @Value("${promotion.discount.percentage}")
    BigDecimal discountPercentage;
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        BigDecimal integralValue = purchaseAmount.divide(BigDecimal.valueOf(100L));
        return discountPercentage.multiply(integralValue);
    }
}
