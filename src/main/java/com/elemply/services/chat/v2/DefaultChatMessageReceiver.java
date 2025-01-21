package com.elemply.services.chat.v2;

import com.elemply.database.postgresql.entity.ChatMessage;
import com.elemply.services.chat.v2.abstractions.ChatMessageReceiver;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
public class DefaultChatMessageReceiver implements ChatMessageReceiver {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public LinkedList<ChatMessage> receive(long chatId) {
        return (LinkedList<ChatMessage>) em.createQuery("SELECT cm FROM ChatMessage cm WHERE cm.chat.id=:id", ChatMessage.class)
                .setParameter("id", chatId).getResultList();
    }
}
