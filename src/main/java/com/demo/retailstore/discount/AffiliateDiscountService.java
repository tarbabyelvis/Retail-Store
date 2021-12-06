package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AffiliateDiscountService implements DiscountService{
   // @Value("${promotion.discount.percentage.affiliate:10}")
    BigDecimal affiliateDiscountPercentage = new BigDecimal(10);
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        if(purchaseAmount==null)
            return BigDecimal.ZERO;
        return purchaseAmount.multiply(affiliateDiscountPercentage).divide(BigDecimal.valueOf(100L));
    }

    @Override
    public UserType getUserType() {
        return UserType.AFFILIATE;
    }
}
