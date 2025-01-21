package com.elemply.services.chat.v2;

import com.elemply.database.postgresql.entity.Chat;
import com.elemply.services.chat.v2.abstractions.ChatCreator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DefaultChatCreator implements ChatCreator {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public long create(long aId, long bId) {
        Chat chat = new Chat();
        chat.setName("");
        chat.setCreatedAt(LocalDateTime.now());
        chat.setGroup(false);

        em.persist(chat);
        return chat.getId();
    }
}
