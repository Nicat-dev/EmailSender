package com.example.emailsender.mapper;

import com.example.emailsender.dto.UserDto;
import com.example.emailsender.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserDto> entityListToDtoList(List<User> users);
    UserDto entityToDto(User user);

}
