package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class RegularDiscountService implements DiscountService{
    @Value("${promotion.discount.regular.amount}")
    BigDecimal regularDiscountAmount;
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        BigDecimal integralValue = purchaseAmount.divide(BigDecimal.valueOf(100L));
        return regularDiscountAmount.multiply(integralValue);
    }

    @Override
    public UserType getUserType() {
        return UserType.REGULAR;
    }
}
