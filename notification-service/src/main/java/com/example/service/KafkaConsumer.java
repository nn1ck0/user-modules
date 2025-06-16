package com.example.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final UserEventSub userEventSub;

    @KafkaListener(topics = "UserEventCreatePublisher", groupId = "notification-group")
    public void consumerUserEventCreate(String msg) {
        if (userEventSub != null) {
            userEventSub.createMsg(msg);
        }
    }
    @KafkaListener(topics = "UserEventDeletePublisher", groupId = "notification-group")
    public void consumerUserEventDelete(String msg) {
        if (userEventSub != null) {
            userEventSub.deleteMsg(msg);
        }
    }
}
