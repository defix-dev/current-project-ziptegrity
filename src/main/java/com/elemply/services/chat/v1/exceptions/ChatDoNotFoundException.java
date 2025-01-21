package com.elemply.services.chat.v1.exceptions;

public class ChatDoNotFoundException extends RuntimeException {
    public ChatDoNotFoundException() {
        super("Chat do not found.");
    }
}
