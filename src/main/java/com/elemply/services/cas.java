package com.elemply.services;

import com.elemply.database.postgresql.repositories.AccountRepository;
import com.elemply.services.account.AccountService;
import com.elemply.services.chat.v1.ChatAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class cas extends AccountService implements ChatAccountService {
    @Autowired
    public cas(AccountRepository accountRepository, BCryptPasswordEncoder encoder) {
        super(accountRepository, encoder);
    }
}
