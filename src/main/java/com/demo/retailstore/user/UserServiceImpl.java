package com.demo.retailstore.user;

import com.demo.retailstore.model.User;
import com.demo.retailstore.user.data.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<UserType> getUserType(Long id) {
        Optional<User> userOptional = findUserById(id);
        if(userOptional.isEmpty())
            throw new RuntimeException(String.format("User with ID: %d not found!",id));
        User user = userOptional.get();
        return Optional.of(user.getUserType());
    }
    private Optional<User> findUserById(Long userId){
        return userRepository.findById(userId);
    }
}
