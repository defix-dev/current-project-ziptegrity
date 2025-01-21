package com.elemply.services.chat.v2.abstractions;

import com.elemply.database.postgresql.entity.Chat;

import java.util.LinkedList;
import java.util.List;

public interface ChatReceiver {
    LinkedList<Chat> receive(long accountId);
}
