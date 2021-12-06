package com.demo.retailstore.bill;

import com.demo.retailstore.bill.data.BillRequestDto;
import com.demo.retailstore.model.Product;
import com.demo.retailstore.product.ProductService;
import com.demo.retailstore.user.UserService;
import com.demo.retailstore.user.data.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

class CalculateBillServiceImplTest {
  private CalculateBillService calculateBillService;
    @BeforeEach
    void setUp() {
        ProductService productService = Mockito.mock(ProductService.class);
        UserService userService = Mockito.mock(UserService.class);
        calculateBillService = new CalculateBillServiceImpl(productService,userService);

        Product stove = new Product(1L,"Stove","Electrical", new BigDecimal(100));
        Product television = new Product(2L,"Television","Electrical", new BigDecimal(100));
        Product rice = new Product(3L,"Rice","Grocery", new BigDecimal(100));

        Mockito.when(userService.getUserType(1L)).thenReturn(Optional.of(UserType.EMPLOYEE));
        Mockito.when(productService.populateProducts(List.of(1L,2L, 3L))).thenReturn(List.of(stove,television,rice));
    }

    @Test
    @DisplayName("Should calculate net payable amount")
    void calculate() {
        List<Long>  productIds = List.of(1L,2L,3L);
        Long userId = 1L;
        BillRequestDto requestDto = BillRequestDto.builder()
                .userId(userId)
                .productIds(productIds)
                .build();
        BigDecimal expectedAmount = new BigDecimal(225);
        BigDecimal actualAmount = calculateBillService.calculate(requestDto);
        Assertions.assertEquals(expectedAmount,actualAmount);
    }
}
