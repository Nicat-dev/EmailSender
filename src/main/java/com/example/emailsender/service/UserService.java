package com.example.emailsender.service;

import com.example.emailsender.dto.UserDto;
import com.example.emailsender.dto.request.UserRequest;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
    UserDto findById(Long id);
    void deleteById(Long id);
    void updateUser(UserRequest userRequest,Long id);

}
