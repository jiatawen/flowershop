package com.flowershop.service.user;

import org.springframework.http.ResponseEntity;

public interface ChatService {
    public ResponseEntity<String> sendChatCompletionRequest(String message);
}
