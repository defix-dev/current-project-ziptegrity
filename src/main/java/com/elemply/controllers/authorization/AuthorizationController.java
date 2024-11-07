package com.elemply.controllers.authorization;

import com.elemply.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {
    private final AccountService accountService;

    @Autowired
    public AuthorizationController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestParam String username,
                                         @RequestParam String password) {
        accountService.registerAccount(username, password);
        return ResponseEntity.ok().build();
    }
}
