package com.elemply.services.account;

import com.elemply.database.postgresql.entity.Account;
import com.elemply.database.postgresql.entity.Role;
import com.elemply.database.postgresql.repositories.AccountRepository;
import com.elemply.services.account.exceptions.AccountDoNotFoundException;
import com.elemply.services.account.exceptions.UnauthorizedAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.encoder = encoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> account = Optional.of(accountRepository.findByUsername(username));

        System.out.println(account.get().getUsername());

        return account.get();
    }

    public void registerAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(encoder.encode(password));
        account.setRoles(Collections.singleton(Role.getDefaultAccountRole()));
        account.setCreatedAt(LocalDateTime.now());

        accountRepository.save(account);
    }

    public Account getCurrentAccount() throws UnauthorizedAccountException {
        Optional<UserDetails> user = Optional
                .ofNullable((UserDetails)(SecurityContextHolder.getContext().getAuthentication().getPrincipal()));

        return getAccountByUsername(user
                .orElseThrow(UnauthorizedAccountException::new).getUsername());
    }

    public Account getAccountByUsername(String username) throws AccountDoNotFoundException {
        return Optional.ofNullable(accountRepository.findByUsername(username))
                .orElseThrow(AccountDoNotFoundException::new);
    }
}
