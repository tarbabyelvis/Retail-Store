package com.demo.retailstore.product;


import com.demo.retailstore.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
 Optional<Product> findById(Long productId);
 List<Product> populateProducts(List<Long> productIds);
}
