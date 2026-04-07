package org.kata.springboot.service;

import org.kata.springboot.dao.UserDao;
import org.kata.springboot.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional (readOnly = true)
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User saveUser(User user) {
        userDao.saveUser(user);
        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public void addUser(String username, int age) {
        User user = new User(username.trim(), age);
        saveUser(user);
    }

    @Override
    public void updateUserById(Long id, String username, int age) {
        User user = new User(username.trim(), age);
        user.setId(id);
        updateUser(user);
    }
}
