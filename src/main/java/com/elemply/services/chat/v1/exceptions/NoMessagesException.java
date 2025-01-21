package com.elemply.services.chat.v1.exceptions;

public class NoMessagesException extends RuntimeException {
    public NoMessagesException() {
        super("No messages in chat");
    }
}
