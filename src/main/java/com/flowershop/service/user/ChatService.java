package com.flowershop.service.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ChatService {
    public ResponseEntity<String> sendChatCompletionRequest(String message);
}
