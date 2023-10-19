package com.example.emailsender.controller;

import com.example.emailsender.dto.UserDto;
import com.example.emailsender.dto.response.BaseResponse;
import com.example.emailsender.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping(value = "/getById")
    ResponseEntity<BaseResponse<UserDto>> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE
                ,"User Succesfully find"
                ,service.findById(id)));
    }

    @GetMapping(value = "/getAll")
    ResponseEntity<BaseResponse<List<UserDto>>> getAll(){
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE,
                "UserList successfully find",service.getAll()));
    }


}
