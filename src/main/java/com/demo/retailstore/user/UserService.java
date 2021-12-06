package com.demo.retailstore.user;

import com.demo.retailstore.user.data.UserType;

import java.util.Optional;

public interface UserService {
      Optional<UserType> getUserType(Long id);
}
