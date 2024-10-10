package com.elemply.services.chat;

import com.elemply.database.postgresql.entity.Account;

public interface ChatAccountService {
    Account getCurrentAccount();
    Account getAccountByUsername(String username);
}
