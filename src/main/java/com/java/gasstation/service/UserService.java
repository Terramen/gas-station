package com.java.gasstation.service;

import com.java.gasstation.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDetails loadUserByUsername(String email);
//    User findByEmail(String email);
    List<User> getAllUsers();
    void saveUsers(User user);
    User getUserById(Long id);
    void deleteUserById(Long id);

}
