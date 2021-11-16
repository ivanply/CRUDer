package com.ivanplyaskin.cruder.controller;

import com.ivanplyaskin.cruder.model.dto.UserDTO;
import com.ivanplyaskin.cruder.model.entity.User;
import com.ivanplyaskin.cruder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(
        value = "/user/{userId}",
        produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable long userId) {
        User user = userService.getUserById(userId);
        return user;
    }

    @GetMapping(
            value = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    @PostMapping(
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.createUser(userDTO);
    }

    @PutMapping(
            value = "/user",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteUserById(userId);
    }
}
