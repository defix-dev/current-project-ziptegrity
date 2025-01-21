package com.elemply.services.chat.v2.abstractions;

import com.elemply.services.chat.v2.abstractions.objects.MessageDetails;

public interface ChatMessageSender {
    void send(long chatId, MessageDetails message);
}
