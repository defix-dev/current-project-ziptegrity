package com.elemply.services.chat.v1;

import com.elemply.database.postgresql.entity.Account;

public interface ChatAccountService {
    Account getCurrentAccount();
    Account getAccountByUsername(String username);
}
