package com.example.userservice.service;

import com.example.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RestTemplateService {
    private final RestTemplate restTemplate;

    public void sendMsg() {
        System.out.println(restTemplate.getForObject("http://localhost:8082/api/v1", String.class));
    }

    public String postUserDto(){
        UserDto userDto = new UserDto(1, "name", "lastname", "email");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/api/v1/{userId}/{orders}")
                .uriVariables(Map.of("userId", 123, "orders", 456));
        System.out.println(builder.build().toUri());
        return restTemplate.postForObject(builder.build().toUri().toString(), userDto, String.class, 123, 456);
    }
}
