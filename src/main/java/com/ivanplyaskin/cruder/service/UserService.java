package com.ivanplyaskin.cruder.service;

import com.ivanplyaskin.cruder.model.dao.impl.UserDao;
import com.ivanplyaskin.cruder.model.dto.UserDTO;
import com.ivanplyaskin.cruder.model.entity.User;
import com.ivanplyaskin.cruder.model.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserDao userDao;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserDao userDao, UserMapper userMapper) {
        this.userDao = userDao;
        this.userMapper = userMapper;
    }

    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userDao.create(user);
    }

    @Transactional(readOnly = true)
    public User getUserById(long id) {
        return userDao.findOne(id);
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.delete(user);
    }

    @Transactional
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }

    @Transactional
    public void updateUser(UserDTO userDTO) {
        User user = userMapper.mapToUser(userDTO);
        userDao.update(user);
    }

    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
