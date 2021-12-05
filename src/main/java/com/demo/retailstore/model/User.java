package com.demo.retailstore.model;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Builder
@NoArgsConstructor
public class User {
    @Id
    private Long id;


}
