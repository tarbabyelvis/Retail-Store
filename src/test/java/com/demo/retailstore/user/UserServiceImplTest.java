package com.demo.retailstore.user;

import com.demo.retailstore.model.User;
import com.demo.retailstore.user.data.UserType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {
   private final UserRepository userRepository = Mockito.mock(UserRepository.class);
   private UserService userService;
    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository);
        User user = new User(1L,"Tarbaby Elvis", UserType.EMPLOYEE);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(user));
    }

    @Test
    @DisplayName("Should get user type")
    void getUserType() {
        UserType expectedUserType = UserType.EMPLOYEE;
        Optional<UserType> actualUserType = userService.getUserType(1L);
        Assertions.assertEquals(Optional.of(expectedUserType),actualUserType);
    }
    @Test
    @DisplayName("Should throw an exception")
    void getUserTypeAndThrow() {
        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class,() -> userService.getUserType(2L));
        Assertions.assertEquals("User with ID: 2 not found!",runtimeException.getMessage());
    }
}
