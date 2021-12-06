package com.demo.retailstore.model;

import com.demo.retailstore.user.data.UserType;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private UserType userType;
}
