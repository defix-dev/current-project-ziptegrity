package com.elemply.services.account.exceptions;

public class AccountDoNotFoundException extends RuntimeException {
    public AccountDoNotFoundException() {
        super("Account do not found.");
    }
}
