package com.example.userservice.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "first_name", nullable = false)
    @Schema(description = "Имя пользователя", example = "Vasya")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @Schema(description = "Фамилия пользователя", example = "Ivanov")
    private String lastName;
    @Column(name = "email", nullable = false)
    @Schema(description = "Email пользователя", example = "something@gmail.com")
    private String email;
}
