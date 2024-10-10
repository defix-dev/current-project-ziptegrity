package com.elemply.services.chat;

import com.elemply.database.postgresql.entity.Chat;
import com.elemply.database.postgresql.entity.ChatMessage;
import com.elemply.services.chat.data.ChatDTO;
import com.elemply.services.chat.data.ChatMessageDTO;
import com.elemply.services.chat.exceptions.ChatDoNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Set;

@Service
public class ChatLoadingService {
    private final ChatUtils chatUtils;

    @Autowired
    public ChatLoadingService(ChatUtils chatUtils) {
        this.chatUtils = chatUtils;
    }

    public LinkedList<ChatMessageDTO> loadMessagesByChatId(long chatId) throws ChatDoNotFoundException {
        LinkedList<ChatMessageDTO> messages = new LinkedList<>();

        Chat curChat = chatUtils.tryGetChatFromCurrentAccount(chatId);

        for (ChatMessage message : curChat.getMessages())
            messages.add(chatUtils.convertChatMessageToDTO(message));

        return messages;
    }

    public LinkedList<ChatDTO> loadChats() {
        LinkedList<ChatDTO> chats = new LinkedList<>();
        Set<Chat> curChats = chatUtils.getChatsFromCurrentAccount();

        for (Chat chat : curChats)
            chats.add(chatUtils.convertChatToDTO(chat));

        return chats;
    }
}
