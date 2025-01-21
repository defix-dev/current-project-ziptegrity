package com.elemply.services.chat.v1.exceptions;

public class ChatAlreadyExistsException extends RuntimeException {
    public ChatAlreadyExistsException() {
        super("Chat already exists.");
    }
}
