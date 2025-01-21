package com.elemply.services.chat.v2.abstractions;

import com.elemply.database.postgresql.entity.ChatMessage;

import java.util.LinkedList;
import java.util.List;

public interface ChatMessageReceiver {
    LinkedList<ChatMessage> receive(long chatId);
}
