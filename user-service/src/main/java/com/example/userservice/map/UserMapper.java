package com.example.userservice.map;

import com.example.userservice.dto.UserDto;
import com.example.userservice.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userId", source = "user.id")
    UserDto userEntityToUserDto(UserEntity user);

    @Mapping(target = "id", source = "userDto.userId")
    UserEntity userDtoToUserEntity(UserDto userDto);
}
