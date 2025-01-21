package com.elemply.configurations;

import com.elemply.services.cas;
import com.elemply.services.chat.v1.ChatAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatConfiguration {
    private final cas accountServiceAbstraction;

    @Autowired
    public ChatConfiguration(cas accountServiceAbstraction) {
        this.accountServiceAbstraction = accountServiceAbstraction;
    }

    @Bean
    public ChatAccountService chatAccountService() {
        return accountServiceAbstraction;
    }
}
