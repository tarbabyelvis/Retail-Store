package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class RegularDiscountService implements DiscountService{
   // @Value("${promotion.discount.regular.amount:5}")
    BigDecimal regularDiscountAmount = new BigDecimal(5);
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        if(purchaseAmount==null)
            return BigDecimal.ZERO;
        BigDecimal integralValue = purchaseAmount.divideToIntegralValue(BigDecimal.valueOf(100L));
        return regularDiscountAmount.multiply(integralValue);
    }

    @Override
    public UserType getUserType() {
        return UserType.REGULAR;
    }
}
