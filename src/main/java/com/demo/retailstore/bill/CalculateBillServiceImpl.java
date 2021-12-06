package com.demo.retailstore.bill;

import com.demo.retailstore.bill.data.BillRequestDto;
import com.demo.retailstore.discount.DiscountFactory;
import com.demo.retailstore.discount.DiscountService;
import com.demo.retailstore.model.Product;
import com.demo.retailstore.product.ProductService;
import com.demo.retailstore.user.UserService;
import com.demo.retailstore.user.data.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.collections.impl.collector.BigDecimalSummaryStatistics;
import org.eclipse.collections.impl.collector.Collectors2;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CalculateBillServiceImpl implements CalculateBillService {
    private final ProductService productService;
    private final UserService userService;
    @Override
    public BigDecimal calculate(BillRequestDto billRequestDto) {
        BigDecimal totalPercentageDiscounts = calculateTotalPercentageDiscounts(billRequestDto);
        List<Product> products = getProducts(billRequestDto.getProductIds());
        BigDecimal totalBillAmount = totalProductsCostsBeforeDiscounts(products);
        BigDecimal regularDiscountForEvery100 = calculateRegularDiscount(totalBillAmount);
        BigDecimal discountTotal = sumRegularDiscountAndPercentageDiscount(regularDiscountForEvery100, totalPercentageDiscounts);
        BigDecimal payableAmount = sumTotalBill(discountTotal, totalBillAmount);
        log.info("Payable amount {}",payableAmount);
        return payableAmount;
    }
    private BigDecimal calculateTotalPercentageDiscounts(BillRequestDto billRequestDto){
        List<Product> products = getProducts(billRequestDto.getProductIds());
        BigDecimalSummaryStatistics summaryStatistics = products.stream()
                .collect(
                        Collectors2.summarizingBigDecimal(product -> calculatePercentageDiscountForUser(billRequestDto.getUserId(), product)));
        return summaryStatistics.getSum()!=null?summaryStatistics.getSum():BigDecimal.ZERO;
    }
    private BigDecimal calculatePercentageDiscountForUser(Long userId, Product product){
        UserType userType = getUserType(userId);
        if(getProductType(product).equalsIgnoreCase("grocery")){
            return BigDecimal.ZERO;
        }
        DiscountService discountService = getDiscountService(userType);
        return discountService.calculateDiscount(product.getAmount());
    }
    private BigDecimal totalProductsCostsBeforeDiscounts(List<Product> products){
        BigDecimalSummaryStatistics summaryStatistics = products.stream()
                .collect(
                        Collectors2.summarizingBigDecimal(Product::getAmount));
        return summaryStatistics.getSum()!=null?summaryStatistics.getSum():BigDecimal.ZERO;
    }
    private BigDecimal calculateRegularDiscount(BigDecimal totalBill){
        DiscountService discountService = DiscountFactory.getDiscountService(UserType.REGULAR);
        return discountService.calculateDiscount(totalBill);
    }
    private BigDecimal sumRegularDiscountAndPercentageDiscount(BigDecimal regularDiscount,BigDecimal percentageDiscount){
        return regularDiscount.add(percentageDiscount);
    }
    private BigDecimal sumTotalBill(BigDecimal discounts, BigDecimal price){
        return price.subtract(discounts);
    }

    private List<Product> getProducts(List<Long> productIds){
        return productService.populateProducts(productIds);
    }
    private String getProductType(Product product){
        return product.getProductType();
    }
    
    private DiscountService getDiscountService(UserType userType){
        return DiscountFactory.getDiscountService(userType);
    }
    private UserType getUserType(Long userId){
        return userService.getUserType(userId)
                .get();
    }

}
