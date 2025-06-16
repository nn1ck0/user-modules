package com.example.userservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventPublisher {
    private static final String topicCreate = "UserEventCreatePublisher";
    private static final String topicDelete = "UserEventDeletePublisher";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void PublishUserCreatedEvent(String email) {
        kafkaTemplate.send(topicCreate, email);
    }

    public void PublishUserDeletedEvent(String email) {
        kafkaTemplate.send(topicDelete, email);
    }
}
