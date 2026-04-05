package org.kata.springboot.dao;

import jakarta.persistence.EntityManager;
import org.kata.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

@Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
}


}
