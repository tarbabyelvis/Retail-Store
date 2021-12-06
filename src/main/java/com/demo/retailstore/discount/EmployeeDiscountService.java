package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class EmployeeDiscountService implements DiscountService {
    @Value("${promotion.discount.percentage.employee}")
    BigDecimal employeeDiscountPercentage;
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        return purchaseAmount.multiply(employeeDiscountPercentage).divide(BigDecimal.valueOf(100L));
    }

    @Override
    public UserType getUserType() {
        return UserType.EMPLOYEE;
    }
}
