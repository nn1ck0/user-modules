package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class UserEventSub {

    public void createMsg(String msg) {
        System.out.println("UserEventSub createMsg:\n " + msg);

    }

    public void deleteMsg(String msg){
        System.out.println("UserEventSub deleteMsg:\n " + msg);

    }
}
