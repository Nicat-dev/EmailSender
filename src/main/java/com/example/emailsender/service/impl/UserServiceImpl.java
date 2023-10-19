package com.example.emailsender.service.impl;

import com.example.emailsender.dto.UserDto;
import com.example.emailsender.dto.request.UserRequest;
import com.example.emailsender.exception.ResourceExistsException;
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
            repository.save(
                    mapper.requestToEntity(userRequest)
            );
        }
    }

    @Override
    public void saveUser(UserRequest request) {
        userExistById(request.getId());
        repository.save(mapper.requestToEntity(request));
    }

    private User getUserById(Long id){
        return repository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(id.toString(),"id cannot  be null",id));
    }

    private void userExistById(Long id){
        if (!repository.existsById(id)){
            throw new ResourceExistsException("User", id.toString(),id);
        }
    }
}
