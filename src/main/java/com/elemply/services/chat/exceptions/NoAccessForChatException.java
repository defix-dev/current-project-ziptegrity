package com.elemply.services.chat.exceptions;

public class NoAccessForChatException extends RuntimeException {
    public NoAccessForChatException() {
        super("Current account do not have access to this chat.");
    }
}
