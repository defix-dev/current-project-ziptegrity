package com.elemply.configurations;

import com.elemply.services.chat.ChatAccountService;
import com.elemply.services.chat.ChatAccountServiceAbstraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfiguration {
    private final ChatAccountServiceAbstraction accountServiceAbstraction;

    @Autowired
    public ChatConfiguration(ChatAccountServiceAbstraction accountServiceAbstraction) {
        this.accountServiceAbstraction = accountServiceAbstraction;
    }

    @Bean
    public ChatAccountService chatAccountService() {
        return accountServiceAbstraction;
    }
}
