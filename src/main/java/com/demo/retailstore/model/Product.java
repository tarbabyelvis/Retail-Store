package com.demo.retailstore.model;

import com.demo.retailstore.model.BaseEntity;
import lombok.*;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String name;
    private String productType;
    private BigDecimal amount;
}
