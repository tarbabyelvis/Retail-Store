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
public class AffiliateDiscountService implements DiscountService{
    @Value("${promotion.discount.percentage.affiliate}")
    BigDecimal affiliateDiscountPercentage;
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        return purchaseAmount.multiply(affiliateDiscountPercentage).divide(BigDecimal.valueOf(100L));
    }

    @Override
    public UserType getUserType() {
        return UserType.AFFILIATE;
    }
}
