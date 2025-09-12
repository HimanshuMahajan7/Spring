package com.example.repository;

import com.example.entity.Account;
import com.example.entity.AccountPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, AccountPK> {
}
