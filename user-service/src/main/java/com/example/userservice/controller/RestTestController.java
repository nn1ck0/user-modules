package com.example.userservice.controller;

import com.example.userservice.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class RestTestController {

    private final RestTemplateService restTemplateService;

    @GetMapping
    public void test(){
        restTemplateService.sendMsg();
    }

    @PostMapping("/post")
    public void postNotification(){
//        ResponseEntity<String> response = restTemplateService.postUserDto();
        System.out.println(restTemplateService.postUserDto());
    }
}
