package com.ivanplyaskin.cruder.model.mapper;

import com.ivanplyaskin.cruder.model.dto.UserDTO;
import com.ivanplyaskin.cruder.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        return user;
    }

    public UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setSurname(userDTO.getSurname());
        return userDTO;
    }
}
