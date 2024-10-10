package com.elemply.database.postgresql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "chat_member")
public class ChatMember {
    @EmbeddedId
    private ChatMemberId id;

    @MapsId("chatId")
    @ManyToOne
    @JoinColumn(name = "chat_id")
    private Chat chat;

    @MapsId("accountId")
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

}
