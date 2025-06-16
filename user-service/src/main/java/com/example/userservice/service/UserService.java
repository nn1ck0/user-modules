package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import com.example.userservice.map.UserMapper;
import com.example.userservice.repo.UserRepoMem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepoMem userRepoMem;
    private final UserEventPublisher userEventPublisher;
    private final UserMapper userMapper;

    public UserDto createUser(UserDto userDto) {

        UserEntity userEntity = userMapper.userDtoToUserEntity(userDto);
        userEventPublisher.PublishUserCreatedEvent(userDto.getEmail());
        return userMapper.userEntityToUserDto(userRepoMem.save(userEntity));
    }

    public void deleteUser(Integer id) {

        userRepoMem.deleteById(id).orElseThrow();
    }

    public UserDto getUserById(Integer id) {

        return userMapper.userEntityToUserDto(userRepoMem.findById(id).orElseThrow());
    }

    public UserDto updateUser(UserDto userDto) {

        UserEntity userEntity = userMapper.userDtoToUserEntity(userDto);
        return userMapper.userEntityToUserDto(userRepoMem.save(userEntity));
    }

}
