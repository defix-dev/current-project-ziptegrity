package com.elemply.database.postgresql.repositories;

import com.elemply.database.postgresql.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    public Account findByUsername(String username);
}
