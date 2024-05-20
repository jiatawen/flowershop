package com.flowershop.controller.user;

import com.flowershop.service.user.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;
    @PostMapping
    @ResponseBody
    public ResponseEntity<String> chat(@RequestParam("message") String message) {

        return chatService.sendChatCompletionRequest(message);
    }
}
