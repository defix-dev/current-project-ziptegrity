package com.elemply.services.chat.v1;

import com.elemply.database.postgresql.entity.ChatMessage;

import java.time.LocalDateTime;
import java.util.Comparator;

public class ChatMessageDateComparator implements Comparator<ChatMessage> {
    @Override
    public int compare(ChatMessage o1, ChatMessage o2) {
        return o1.getSentAt().compareTo(o2.getSentAt());
    }
}
