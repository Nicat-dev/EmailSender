package com.example.emailsender.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "users")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 3,max = 25,message = "name value range between 3-25")
    @Column(name = "name",nullable = false)
    private String name;
    @Size(min = 3,max = 30,message = "surname value range between 3-25")
    @Column(name = "surname",nullable = false)
    private String surname;
    @Size(min = 10,max = 60,message = "email range between 10-60")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*" +
            "@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$")
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Min(value = 18, message = "age can not under 18")
    @Max(value = 100, message = "age can not over 100")
    @Column(name = "age",nullable = false)
    private Integer age;
    @Column(name = "location")
    private String location;
}
