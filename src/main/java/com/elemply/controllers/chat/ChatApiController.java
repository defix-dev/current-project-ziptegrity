package com.elemply.controllers.chat;

import com.elemply.services.chat.*;
import com.elemply.services.chat.data.ChatPreviewDTO;
import com.elemply.services.chat.data.ChatMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@Controller
@RequestMapping("/api/chat")
public class ChatApiController {
    private final ChatCreationService creationService;
    private final ChatLoadingService loadingService;

    @Autowired
    public ChatApiController(ChatCreationService creationService, ChatLoadingService loadingService) {
        this.creationService = creationService;
        this.loadingService = loadingService;
    }

    @PostMapping("/add_chat")
    public ResponseEntity<Void> addChat(@RequestParam String username) {
        creationService.createSingleChat(username);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get_chats")
    public ResponseEntity<LinkedList<ChatPreviewDTO>> getChats() {
        return ResponseEntity.ok(loadingService.loadChats());
    }

    @GetMapping("/get_messages/{chatId}")
    public ResponseEntity<LinkedList<ChatMessageDTO>> getMessages(@PathVariable long chatId) {
        return ResponseEntity.ok(loadingService.loadMessagesByChatId(chatId));
    }
}
