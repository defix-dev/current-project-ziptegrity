package com.elemply.services.account.exceptions;

public class UnauthorizedAccountException extends RuntimeException {
    public UnauthorizedAccountException() {
        super("Account is not authorized.");
    }
}
