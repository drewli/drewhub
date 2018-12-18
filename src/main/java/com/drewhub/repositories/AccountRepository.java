package com.drewhub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.drewhub.models.Account;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Account findAccountByUsername(String username);
}
