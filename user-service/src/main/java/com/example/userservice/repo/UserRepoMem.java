package com.example.userservice.repo;

import com.example.userservice.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepoMem {
    private List<UserEntity> list = new ArrayList<>();

    public UserEntity save(UserEntity userEntity) {
        userEntity.setId(list.size());
        list.add(userEntity);
        return userEntity;
    }

    public Optional<UserEntity> findById(Integer id) {
        return Optional.of(list.get(id));

    }

    public Optional<UserEntity> deleteById(Integer id) {
        return Optional.of(list.get(id));
    }

    public UserEntity updateUser(UserEntity userEntity) {
        list.set(userEntity.getId(), userEntity);
        return userEntity;
    }



}
