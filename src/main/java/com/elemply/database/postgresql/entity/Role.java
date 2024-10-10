package com.elemply.database.postgresql.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {
    @Transient
    private static final int USER_ROLE_ID = 1;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)

    @Override
    public String getAuthority() {
        return null;
    }

    public static Role getDefaultAccountRole() {
        return new Role(USER_ROLE_ID);
    }
}
