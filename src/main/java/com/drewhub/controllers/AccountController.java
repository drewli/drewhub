package com.drewhub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drewhub.models.Account;
import com.drewhub.services.AccountService;

@CrossOrigin
@RestController
@RequestMapping(value="/users")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Account>> findAll() {
		return new ResponseEntity<List<Account>>(accountService.findAll(),
				HttpStatus.OK);
	}

	@GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> findByUsername(@PathVariable("id") Integer id) {
		return new ResponseEntity<Account>(accountService.findById(id),
				HttpStatus.OK);
	}

	@PostMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> add(@RequestBody Account account) {
		try {
			Account acc = accountService.add(account);
			return new ResponseEntity<Account>(acc, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error");
		}
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Account> update(@RequestBody Account account) {
		try {
			Account acc = accountService.update(account);
			return new ResponseEntity<Account>(acc, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error");
		}
	}

	@PutMapping(value="/{id}", produces=MediaType.TEXT_PLAIN_VALUE)
	public String server(@PathVariable Integer id) {
		return System.getenv("TEST_VAR");
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Account> delete(@PathVariable("id") Integer id) {
		try {
			Boolean deleted = accountService.deleteById(id);
			if (deleted) {
				return new ResponseEntity<Account>(HttpStatus.OK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("Error");
	}
}
