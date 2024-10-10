package com.elemply.services.chat;


import com.elemply.database.postgresql.entity.Chat;
import com.elemply.database.postgresql.entity.ChatMessage;
import com.elemply.services.chat.data.ChatDTO;
import com.elemply.services.chat.data.ChatMessageDTO;
import com.elemply.services.chat.exceptions.NoAccessForChatException;
import com.elemply.services.chat.exceptions.NoMessagesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChatUtils {
    private final ChatAccountService chatAccountService;

    @Autowired
    public ChatUtils(ChatAccountService chatAccountService) {
        this.chatAccountService = chatAccountService;
    }

    public AccountChatContext getCurrentAccountChatContext() {
        return new AccountChatContext(chatAccountService.getCurrentAccount());
    }

    public AccountChatContext getAccountChatContextByUsername(String username) {
        return new AccountChatContext(chatAccountService.getAccountByUsername(username));
    }

    public Set<Chat> getChatsFromCurrentAccount() {
        return getCurrentAccountChatContext().getChats();
    }

    public Chat tryGetChatFromCurrentAccount(long chatId) {
        return tryGetChatFromAccount(getCurrentAccountChatContext(), chatId);
    }

    public Chat tryGetChatFromAccount(AccountChatContext account, long chatId) throws NoAccessForChatException {
        return account.getChats()
                .stream().filter(chat -> chat.getId() == chatId).findFirst().orElseThrow(NoAccessForChatException::new);
    }

    public ChatMessageDTO convertChatMessageToDTO(ChatMessage message) {
        return new ChatMessageDTO(
                message.getMessage(),
                message.getAccount().getUsername(),
                message.getSentAt());
    }

    public ChatDTO convertChatToDTO(Chat chat) {
        ChatDTO chatDTO = new ChatDTO();
        chatDTO.setChatId(chat.getId());
        chatDTO.setName(chat.getName());

        ChatMessage lastMessage = getLastMessageFromChat(chat);
        chatDTO.setLastMessage(lastMessage.getMessage());
        chatDTO.setLastMessageSentAt(lastMessage.getSentAt());

        return chatDTO;
    }

    private ChatMessage getLastMessageFromChat(Chat chat) throws NoMessagesException {
        return chat.getMessages().stream().max(new ChatMessageDateComparator())
                .orElseThrow(NoMessagesException::new);
    }
}
