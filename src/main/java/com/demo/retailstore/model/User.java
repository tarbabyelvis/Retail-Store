package com.demo.retailstore.model;

import com.demo.retailstore.user.data.UserType;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false, updatable = false)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(length = 100)
    private UserType userType;
}
