package com.elemply.services.chat.v2;

import com.elemply.database.postgresql.entity.ChatMember;
import com.elemply.services.chat.v2.abstractions.ChatMemberReceiver;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.LinkedList;

@Service
public class DefaultChatMemberReceiver implements ChatMemberReceiver {
    @PersistenceContext
    private EntityManager em;

    @Override
    public LinkedList<ChatMember> receive(long chatId) {
        return (LinkedList<ChatMember>) em.createQuery("SELECT cm FROM ChatMember cm WHERE cm.chat.id=:id", ChatMember.class)
                .setParameter("id", chatId).getResultList();
    }
}
