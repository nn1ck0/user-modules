package com.example.userservice.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
}
