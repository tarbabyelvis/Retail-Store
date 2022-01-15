package com.demo.retailstore.product;

import com.demo.retailstore.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

class ProductServiceImplTest {
 private final ProductRepository productRepository = Mockito.mock(ProductRepository.class);
 private ProductService productService;
    @BeforeEach
    void setUp() {
     productService = new ProductServiceImpl(productRepository);

       Product stove = new Product(1L,"Stove","Electrical", new BigDecimal(400));
       Product television = new Product(2L,"Television","Electrical", new BigDecimal(350));
       Product rice = new Product(3L,"Rice","Grocery", new BigDecimal(90));
       Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(stove));
       Mockito.when(productRepository.findById(2L)).thenReturn(Optional.of(television));
       Mockito.when(productRepository.findById(3L)).thenReturn(Optional.of(rice));
    }

    @Test
    void findById() {
       Product expectedProduct = new Product(1L,"Stove","Electrical", new BigDecimal(400));
       Optional<Product> actualProduct = productService.findById(1L);
       Assertions.assertEquals(Optional.of(expectedProduct),actualProduct);
    }

    @Test
    void populateProducts() {
       Product stove = new Product(1L,"Stove","Electrical", new BigDecimal(400));
       Product television = new Product(2L,"Television","Electrical", new BigDecimal(350));
       Product rice = new Product(3L,"Rice","Grocery", new BigDecimal(90));
       List<Long> productIds = List.of(1L,2L,3L);
       List<Product> expectedProducts = List.of(stove,television,rice);
       List<Product> actualProducts = productService.populateProducts(productIds);
       Assertions.assertEquals(expectedProducts,actualProducts);
       Assertions.assertEquals(actualProducts.size(),3);
    }
}
