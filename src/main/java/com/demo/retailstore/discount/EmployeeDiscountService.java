package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class EmployeeDiscountService implements DiscountService {
    //@Value("${promotion.discount.percentage.employee:30}")
    BigDecimal employeeDiscountPercentage = new BigDecimal(30);
    @Override
    public BigDecimal calculateDiscount(BigDecimal purchaseAmount) {
        if(purchaseAmount==null)
            return BigDecimal.ZERO;
        return purchaseAmount.multiply(employeeDiscountPercentage).divide(BigDecimal.valueOf(100L));
    }

    @Override
    public UserType getUserType() {
        return UserType.EMPLOYEE;
    }
}
