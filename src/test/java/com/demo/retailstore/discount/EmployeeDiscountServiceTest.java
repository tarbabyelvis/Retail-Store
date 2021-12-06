package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDiscountServiceTest {
   private DiscountService discountService;
    @BeforeEach
    void setUp() {
        discountService = new EmployeeDiscountService();
    }
    @Test
    @DisplayName("should calculate the discount for employee")
    void calculateDiscount(){
        BigDecimal expectedDiscount = new BigDecimal(30);
        BigDecimal actualDiscount = discountService.calculateDiscount(new BigDecimal(100));
        assertEquals(expectedDiscount,actualDiscount);
    }
    @Test
    @DisplayName("should calculate the discount for null purchase amount")
    void calculateDiscountForNullAmount(){
        BigDecimal expectedDiscount = BigDecimal.ZERO;
        BigDecimal actualDiscount = discountService.calculateDiscount(null);
        assertEquals(expectedDiscount,actualDiscount);
    }
    @Test
    @DisplayName("Should get user type")
    void getUserType() {
        UserType expectedUserType = UserType.EMPLOYEE;
        UserType actualUserType = discountService.getUserType();
        Assertions.assertEquals(expectedUserType,actualUserType);
    }
}
