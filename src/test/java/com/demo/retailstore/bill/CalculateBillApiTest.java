package com.demo.retailstore.bill;

import com.demo.retailstore.bill.data.BillRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculateBillApi.class)
class CalculateBillApiTest {
    @Autowired
    private MockMvc mvc;
    @MockBean
    private CalculateBillService calculateBillService;
    @BeforeEach
    void setUp() {
        List<Long> productIds = List.of(1L,2L,3L);
        Long userId = 1L;
        BillRequestDto requestDto = BillRequestDto.builder()
                .userId(userId)
                .productIds(productIds)
                .build();
        Mockito.when(calculateBillService.calculate(requestDto)).thenReturn(new BigDecimal(225));
    }

    @Test
    @DisplayName("Should return calculated payable amount")
    void calculate() throws Exception {
        List<Long> productIds = List.of(1L,2L,3L);
        Long userId = 1L;
        BillRequestDto requestDto = BillRequestDto.builder()
                .userId(userId)
                .productIds(productIds)
                .build();


        mvc.perform( MockMvcRequestBuilders
                        .post("/bill/calculate")
                        .content(asJsonString(requestDto))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
