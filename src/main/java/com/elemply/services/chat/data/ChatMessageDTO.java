package com.elemply.services.chat.data;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessageDTO {
    private String message;
    private String sender;
    private LocalDateTime sentAt;
}
