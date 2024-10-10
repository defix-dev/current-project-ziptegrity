package com.elemply.services.chat;

import com.elemply.database.postgresql.entity.Account;
import com.elemply.database.postgresql.entity.Chat;
import com.elemply.database.postgresql.entity.ChatMember;
import com.elemply.database.postgresql.entity.ChatMemberId;
import com.elemply.database.postgresql.repositories.ChatRepository;
import com.elemply.services.chat.exceptions.ChatAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class ChatCreationService {
    private final ChatRepository chatRepository;
    private final ChatAccountService chatAccountService;

    @Autowired
    public ChatCreationService(ChatRepository chatRepository, ChatAccountService chatAccountService) {
        this.chatRepository = chatRepository;
        this.chatAccountService = chatAccountService;
    }

    public void createSingleChat(String username) throws ChatAlreadyExistsException {
        Account curAccount = chatAccountService.getCurrentAccount();
        Account targetAccount = chatAccountService.getAccountByUsername(username);

        if (isChatExists(new AccountChatContext(curAccount),
                new AccountChatContext(targetAccount))) {
            throw new ChatAlreadyExistsException();
        }

        Chat chat = new Chat();
        chat.setName("");
        chat.setGroup(false);
        chat.setMembers(new HashSet<>(Arrays.asList(
                createChatMember(curAccount, chat),
                createChatMember(targetAccount, chat)
        )));
        chat.setMessages(new HashSet<>());
        chat.setCreatedAt(LocalDateTime.now());

        chatRepository.save(chat);
    }

    private boolean isChatExists(AccountChatContext a, AccountChatContext b) {
        return a.getChats().stream().anyMatch(chat -> b.getChats().contains(chat));
    }

    private ChatMember createChatMember(Account account, Chat chat) {
        return new ChatMember(new ChatMemberId(chat.getId(), account.getId()),
                chat, account);
    }
}
