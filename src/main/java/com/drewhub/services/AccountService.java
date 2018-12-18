package com.drewhub.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drewhub.models.Account;
import com.drewhub.repositories.AccountRepository;

@Service
@Transactional
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
	
	public Account findByUsername(String username) {
		return accountRepository.findAccountByUsername(username);
	}
	
	public Account findById(Integer id) {
		return accountRepository.findOne(id);
	}
	
	public Account add(Account account) {
		account.setAccountId(null);
		return accountRepository.saveAndFlush(account);
	}
	
	public Account update(Account account) {
		Account temp = accountRepository.findOne(account.getAccountId());
		if (temp == null) {
			throw new RuntimeException("Account not found...");
		}
		return accountRepository.saveAndFlush(account);
	}
	
	public boolean deleteById(Integer id) {
		Account temp = accountRepository.findOne(id);
		accountRepository.delete(temp);
		return temp != null;
	}
}
