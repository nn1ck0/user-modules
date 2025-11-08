package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.map.UserMapper;
import com.example.userservice.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserEventPublisher userEventPublisher;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto userDto) {
        UserEntity userEntity = userMapper.userDtoToUserEntity(userDto);
        userEventPublisher.PublishUserCreatedEvent(userDto.getEmail());
        return userMapper.userEntityToUserDto(userRepo.save(userEntity));
    }

    public void deleteUser(Integer id) {
        UserEntity userEntity = userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("user not found"));
        userEventPublisher.PublishUserDeletedEvent(userEntity.getEmail());
        userRepo.deleteById(id);
    }

    public UserDto getUserById(Integer id) {
        return userMapper.userEntityToUserDto(userRepo.findById(id).orElseThrow(()-> new NoSuchElementException("user not found")));
    }

    public UserDto updateUser(Integer id, UserDto userDto) {
        UserEntity userEntity = userRepo.findById(id).orElseThrow(() -> new NoSuchElementException("user not found"));
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        userEntity.setEmail(userDto.getEmail());
        return userMapper.userEntityToUserDto(userRepo.save(userEntity));
    }

}
