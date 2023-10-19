package com.example.emailsender.controller;

import com.example.emailsender.dto.response.BaseResponse;
import com.example.emailsender.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "/email")
public class EmailController {

    private final EmailSenderService emailSenderService;

    @PostMapping(name = "/send")
    ResponseEntity<BaseResponse<String>> sendMessage(@RequestBody String email, String subject,String body){
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE,
                "Message sendded",
                emailSenderService.messageSender(email,subject,body)));
    }

}
