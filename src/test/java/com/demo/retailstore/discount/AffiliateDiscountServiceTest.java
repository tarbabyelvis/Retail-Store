package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AffiliateDiscountServiceTest {
    private DiscountService discountService;
    @BeforeEach
    void setUp() {
        discountService = new AffiliateDiscountService();
    }
    @Test
    @DisplayName("should calculate the discount for affiate customer")
    void calculateDiscount(){
        BigDecimal expectedDiscount = new BigDecimal(10);
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
    @DisplayName("Should get AFFILIATE user type")
    void getUserType() {
        UserType expectedUserType = UserType.AFFILIATE;
        UserType actualUserType = discountService.getUserType();
        Assertions.assertEquals(expectedUserType,actualUserType);
    }
}
