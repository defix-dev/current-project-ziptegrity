package com.elemply.controllers.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services/chat")
public class ChatController {
    @GetMapping
    public String chat(Model model) {
        return "chat_home";
    }
}
