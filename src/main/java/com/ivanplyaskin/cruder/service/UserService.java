package com.ivanplyaskin.cruder.service;

import com.ivanplyaskin.cruder.model.dao.impl.UserDao;
import com.ivanplyaskin.cruder.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {

    private final UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void createUser(User user) {
        userDao.create(user);
    }

    @Transactional
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.update(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
