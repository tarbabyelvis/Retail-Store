package com.demo.retailstore.user;

import com.demo.retailstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
