package com.elemply.controllers.authorization;

import com.elemply.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authorization")
public class AuthorizationApiController {
    private final AccountService accountService;

    @Autowired
    public AuthorizationApiController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/check_auth_status")
    public ResponseEntity<Boolean> checkAuthStatus() {
        try {
            accountService.getCurrentAccount();
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }

    @GetMapping("/get_account_username")
    public ResponseEntity<String> getAccountUsername() {
        return ResponseEntity.ok(accountService.getCurrentAccount().getUsername());
    }
}
