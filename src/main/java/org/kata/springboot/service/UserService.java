package org.kata.springboot.service;

import org.kata.springboot.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);

    void addUser(String username, int age);
    void updateUserById(Long id, String username, int age);
}
