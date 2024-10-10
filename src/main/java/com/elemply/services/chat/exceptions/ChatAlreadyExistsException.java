package com.elemply.services.chat.exceptions;

public class ChatAlreadyExistsException extends RuntimeException {
    public ChatAlreadyExistsException() {
        super("Chat already exists.");
    }
}
