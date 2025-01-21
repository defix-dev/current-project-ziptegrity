package com.elemply.services.chat.v2.preparers;

import com.elemply.services.chat.v2.abstractions.ChatMemberReceiver;
import com.elemply.services.chat.v2.abstractions.ChatMessageReceiver;
import com.elemply.services.chat.v2.abstractions.ChatReceiver;
import com.elemply.services.chat.v2.preparers.objects.ChatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Optional;

@Service
public class ChatPreparer {
    private final ChatReceiver chatReceiver;

    @Autowired
    public ChatPreparer(ChatReceiver chatReceiver) {
        this.chatReceiver = chatReceiver;
    }

    public ChatDTO prepare(long accountId,  data) {
        me
    }
}
