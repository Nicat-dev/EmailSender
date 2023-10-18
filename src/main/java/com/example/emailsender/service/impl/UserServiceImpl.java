package com.example.emailsender.service.impl;

import com.example.emailsender.dto.UserDto;
import com.example.emailsender.dto.request.UserRequest;
import com.example.emailsender.exception.ResourceNotFoundException;
import com.example.emailsender.mapper.UserMapper;
import com.example.emailsender.model.User;
import com.example.emailsender.repositories.UserRepository;
import com.example.emailsender.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final UserMapper mapper;

    @Override
    public List<UserDto> getAll() {
        return mapper.entityListToDtoList(repository.findAll());
    }

    @Override
    public UserDto findById(Long id) {
        return mapper.entityToDto(getUserById(id));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void updateUser(UserRequest userRequest, Long id) {
        if (Objects.nonNull(userRequest)){
            User user = getUserById(id);
            repository.save(
                    user = User.builder()
                            .name(userRequest.getName())
                            .surname(userRequest.getSurname())
                            .email(userRequest.getEmail())
                            .age(userRequest.getAge())
                            .location(userRequest.getLocation())
                            .build()
            );
        }
    }

    private User getUserById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id.toString(),"id cannot  be null",id));
    }
}
