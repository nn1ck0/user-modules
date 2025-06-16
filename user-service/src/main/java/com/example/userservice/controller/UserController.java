package com.example.userservice.controller;


import com.example.userservice.dto.UserDto;
import com.example.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "UserController", description = "Some user controller")
public class UserController {

    private final UserService userService;

    @Parameter(name = "UserDto", description = "Принимаемый параметр DTO пользователя")
    @Operation(summary = "Создание пользователя", description = "Пример создания пользователя")
    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto user) {
        return userService.createUser(user);
    }

    @Operation(summary = "Удаление пользователя", description = "Удаление пользователя по ID")
    @Parameter(name = "ID", description = "Принимаемый параметр - id пользователя", example = "1")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь удален")
    })
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @GetMapping("/{id}")
    public UserDto getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PutMapping("/update")
    public UserDto updateUser(@RequestBody UserDto user) {
        return userService.updateUser(user);
    }
}
