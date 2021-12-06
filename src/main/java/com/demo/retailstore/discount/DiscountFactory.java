package com.demo.retailstore.discount;

import com.demo.retailstore.user.data.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class DiscountFactory {
    private static final Map<UserType, DiscountService> discountServiceCache = new HashMap<>();
    @Autowired
    private DiscountFactory(Set<DiscountService> discountServices){
        for(DiscountService service: discountServices){
            discountServiceCache.put(service.getUserType(),service);
        }
    }
    public static DiscountService getDiscountService(UserType userType){
        DiscountService discountService = discountServiceCache.get(userType);
        if(discountService==null){
            throw new RuntimeException(String.format("Unknown discount service for user-type %s",userType));
        }
        return discountService;
    }
}
