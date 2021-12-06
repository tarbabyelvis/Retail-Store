package com.demo.retailstore.product;

import com.demo.retailstore.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    @Transactional
    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> populateProducts(List<Long> productIds) {
        return productIds.stream()
                .map(productId ->{
                    Optional<Product> productOptional = findById(productId);
                    if(productOptional.isEmpty())
                        throw new RuntimeException(String.format("Product with ID: %d not found",productId));
                    return productOptional.get();
                })
                .collect(Collectors.toList());
    }
}
