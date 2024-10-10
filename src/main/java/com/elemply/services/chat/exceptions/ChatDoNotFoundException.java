package com.elemply.services.chat.exceptions;

public class ChatDoNotFoundException extends RuntimeException {
    public ChatDoNotFoundException() {
        super("Chat do not found.");
    }
}
