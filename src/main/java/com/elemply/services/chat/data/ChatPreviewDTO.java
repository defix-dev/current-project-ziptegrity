package com.elemply.services.chat.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatPreviewDTO {
    private String chatMemberUsername;
    private String messageOwner;
    private String message;
    private LocalDateTime messageSentAt;
    private long chatId;
}
