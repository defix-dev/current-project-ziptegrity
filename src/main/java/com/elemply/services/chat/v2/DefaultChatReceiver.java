package com.elemply.services.chat.v2;

import com.elemply.database.postgresql.entity.Chat;
import com.elemply.services.chat.v2.abstractions.ChatReceiver;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DefaultChatReceiver implements ChatReceiver {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public LinkedList<Chat> receive(long accountId) {
        return (LinkedList<Chat>) em.createQuery("SELECT c.chat From ChatMember c WHERE c.account.id=:id", Chat.class)
                .setParameter("id", accountId).getResultList();
    }
}
