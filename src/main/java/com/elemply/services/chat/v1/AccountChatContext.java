package com.elemply.services.chat.v1;

import com.elemply.database.postgresql.entity.Account;
import com.elemply.database.postgresql.entity.Chat;
import com.elemply.database.postgresql.entity.ChatMember;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
public class AccountChatContext {
    private final Set<Chat> chats;
    private final long id;

    public AccountChatContext(Account account) {
        chats = new HashSet<>(account.getMembers().stream().map(ChatMember::getChat).toList());
        id = account.getId();
    }
}
