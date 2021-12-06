package com.demo.retailstore.discount;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class DiscountServiceImplTest {

    private DiscountService discountService = new RegularDiscountService();
    @BeforeEach
    void setUp() {
    }
    @Test
    @DisplayName("should calcuate the discount for customer")
    void calculateDiscount(){
        BigDecimal expectedDiscount = new BigDecimal(45);
        BigDecimal actualDiscount = discountService.calculateDiscount(new BigDecimal(990));
        assertEquals(expectedDiscount,actualDiscount);
    }
}
