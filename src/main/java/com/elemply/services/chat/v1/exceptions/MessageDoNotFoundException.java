package com.elemply.services.chat.v1.exceptions;

public class MessageDoNotFoundException extends RuntimeException {
    public MessageDoNotFoundException() {
        super("Message do not found.");
    }
}
