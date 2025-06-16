package com.example.userservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
//@Entity
//@Table(name = "users")
public class UserEntity {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "id")
    private Integer id;
    //@Column(name = "first_name")
    @Schema(description = "Имя пользователя", example = "Vasya")
    private String firstName;
    //@Column(name = "last_name")
    @Schema(description = "Фамилия пользователя", example = "Ivanov")
    private String lastName;
    //@Column(name = "email")
    @Schema(description = "Email пользователя", example = "something@gmail.com")
    private String email;
}
