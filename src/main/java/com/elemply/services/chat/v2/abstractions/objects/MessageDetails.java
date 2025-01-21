package com.elemply.services.chat.v2.abstractions.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageDetails {
    private long senderId;
    private String message;
}
