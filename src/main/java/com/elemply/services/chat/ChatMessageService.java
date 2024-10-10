package com.elemply.services.chat;

import com.elemply.database.postgresql.entity.Account;
import com.elemply.database.postgresql.entity.ChatMessage;
import com.elemply.database.postgresql.repositories.ChatMessageRepository;
import com.elemply.services.account.AccountService;
import com.elemply.services.chat.exceptions.ChatDoNotFoundException;
import com.elemply.services.chat.exceptions.MessageDoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatMessageService {
    private final ChatUtils chatUtils;
    private final ChatMessageRepository messageRepository;
    private final ChatAccountService chatAccountService;

    @Autowired
    public ChatMessageService(ChatUtils chatUtils, ChatMessageRepository messageRepository,
                              ChatAccountService chatAccountService) {
        this.chatUtils = chatUtils;
        this.messageRepository = messageRepository;
        this.chatAccountService = chatAccountService;
    }

    public long saveSingleMessageByChatId(long chatId, String content)
            throws ChatDoNotFoundException {
        ChatMessage message = new ChatMessage();
        message.setChat(chatUtils.tryGetChatFromCurrentAccount(chatId));
        message.setAccount(chatAccountService.getCurrentAccount());
        message.setMessage(content);
        message.setSentAt(LocalDateTime.now());

        messageRepository.save(message);
        return message.getId();
    }

    public ChatMessage getMessageById(long messageId) throws MessageDoNotFoundException {
        return messageRepository.findById(messageId).orElseThrow(MessageDoNotFoundException::new);
    }
}
