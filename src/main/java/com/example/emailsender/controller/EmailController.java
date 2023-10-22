package com.example.emailsender.controller;

import com.example.emailsender.dto.response.BaseResponse;
import com.example.emailsender.service.EmailSenderService;
import jakarta.mail.MessagingException;
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

    @PostMapping(name = "/sendWithAttachment")
    ResponseEntity<BaseResponse<String>> sendMessageWithAttachment(@RequestBody String email,String subject,String body,
                                                                   String attachment) throws MessagingException {
        return ResponseEntity.ok(new BaseResponse<>(Boolean.TRUE,"Message successfully send with attcahment",
                emailSenderService.sendEmailWithAttachment(email,body,subject,attachment)));
    }

}
