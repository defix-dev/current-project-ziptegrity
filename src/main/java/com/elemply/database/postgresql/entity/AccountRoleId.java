package com.elemply.database.postgresql.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class AccountRoleId implements Serializable {
    private long accountId;
    private int roleId;
}
