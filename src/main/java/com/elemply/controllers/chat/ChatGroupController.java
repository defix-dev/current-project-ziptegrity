package com.elemply.controllers.chat;

import com.elemply.services.chat.data.ChatMessageDTO;
import com.elemply.services.chat.ChatMessageService;
import com.elemply.services.chat.ChatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/services/chat/group")
public class ChatGroupController {
    private final ChatMessageService messageService;
    private final ChatUtils chatUtils;

    @Autowired
    public ChatGroupController(ChatMessageService messageService,
                               ChatUtils chatUtils) {
        this.messageService = messageService;
        this.chatUtils = chatUtils;
    }

    @MessageMapping("/send_message/{chatId}")
    @SendTo("/topic/messages/{chatId}")
    public ChatMessageDTO sendMessage(String message, @DestinationVariable long chatId,
                                      SimpMessageHeaderAccessor accessor) {
        SecurityContextHolder.setContext((SecurityContext)(Objects.requireNonNull(accessor.getSessionAttributes()).get("SEC_CTX")));
        return chatUtils.convertChatMessageToDTO(messageService
                .getMessageById(messageService.saveSingleMessageByChatId(chatId, message)));
    }
}
