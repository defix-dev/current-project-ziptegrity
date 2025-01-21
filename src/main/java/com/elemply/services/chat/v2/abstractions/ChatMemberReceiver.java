package com.elemply.services.chat.v2.abstractions;

import com.elemply.database.postgresql.entity.ChatMember;

import java.util.LinkedList;

public interface ChatMemberReceiver {
    LinkedList<ChatMember> receive(long chatId);
}
