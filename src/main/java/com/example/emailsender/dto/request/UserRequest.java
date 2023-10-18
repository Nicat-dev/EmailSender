package com.example.emailsender.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String location;
    private Integer age;
}
