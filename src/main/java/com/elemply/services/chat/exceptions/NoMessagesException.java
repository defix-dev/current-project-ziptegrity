package com.elemply.services.chat.exceptions;

public class NoMessagesException extends RuntimeException {
    public NoMessagesException() {
        super("No messages in chat");
    }
}
