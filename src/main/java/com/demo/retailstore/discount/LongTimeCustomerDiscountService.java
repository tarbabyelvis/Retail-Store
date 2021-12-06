package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LongTimeCustomerDiscountService implements DiscountService{
    //@Value("${promotion.discount.percentage.customer-long-time:5}")
    BigDecimal longTimeCustomerDiscountPercentage = new BigDecimal(5);
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        if(purchaseAmount==null)
            return BigDecimal.ZERO;
        return purchaseAmount.multiply(longTimeCustomerDiscountPercentage).divide(BigDecimal.valueOf(100L));
    }

    @Override
    public UserType getUserType() {
        return UserType.LOND_TIME_CUSTOMER;
    }
}
