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
public class ChatDTO {
    private String name;
    private String lastMessage;
    private LocalDateTime lastMessageSentAt;
    private long chatId;
}
