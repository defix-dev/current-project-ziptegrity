package com.elemply.services.chat.exceptions;

public class MessageDoNotFoundException extends RuntimeException {
    public MessageDoNotFoundException() {
        super("Message do not found.");
    }
}
