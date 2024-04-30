package com.flowershop.service.impl.user;

import com.flowershop.service.user.ChatService;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatServiceImpl implements ChatService {
    @Override
    public ResponseEntity<String> sendChatCompletionRequest(String message) {
        // 构造请求的Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer sk-qOBqLqDzDPxVM955fJ3uRUm2C8BissB8yx9VwwJhGEDwK0X8");

        // 构造请求的Body
        String requestBody = "{\"model\": \"gpt-3.5-turbo\",\"messages\": [{\"role\": \"user\", \"content\": \""+message+"\"}]}";

        // 构造请求实体
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        // 发送POST请求
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://api.chatanywhere.tech/v1/chat/completions",
                HttpMethod.POST,
                requestEntity,
                String.class
        );

        // 返回响应
        return responseEntity;
    }
}
