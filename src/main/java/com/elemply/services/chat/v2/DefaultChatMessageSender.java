package com.elemply.services.chat.v2;

import com.elemply.database.postgresql.entity.Account;
import com.elemply.database.postgresql.entity.Chat;
import com.elemply.database.postgresql.entity.ChatMessage;
import com.elemply.services.chat.v2.abstractions.ChatMessageSender;
import com.elemply.services.chat.v2.abstractions.objects.MessageDetails;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class DefaultChatMessageSender implements ChatMessageSender {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void send(long chatId, MessageDetails message) {
        Account account = em.find(Account.class, message.getSenderId());
        if(account == null) throw new IllegalArgumentException("Account do not found.");

        Chat chat = em.find(Chat.class, chatId);
        if(chat == null) throw new IllegalArgumentException("Chat do not found.");

        ChatMessage msg = new ChatMessage();
        msg.setMessage(message.getMessage());
        msg.setChat(chat);
        msg.setAccount(account);
        msg.setSentAt(LocalDateTime.now());

        em.persist(msg);
    }
}
