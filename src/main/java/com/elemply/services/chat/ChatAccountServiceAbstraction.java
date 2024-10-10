package com.elemply.services.chat;

import com.elemply.database.postgresql.repositories.AccountRepository;
import com.elemply.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ChatAccountServiceAbstraction extends AccountService
        implements ChatAccountService {
    @Autowired
    public ChatAccountServiceAbstraction(AccountRepository accountRepository, BCryptPasswordEncoder encoder) {
        super(accountRepository, encoder);
    }
}
