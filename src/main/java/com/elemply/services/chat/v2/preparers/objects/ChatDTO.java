package com.elemply.services.chat.v2.preparers.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatDTO {
    private String name;
    private String lastMessage;
    private String id;
}
