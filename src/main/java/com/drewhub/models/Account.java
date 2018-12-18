package com.drewhub.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;


@Entity
@Component
@Table
@SequenceGenerator(name="accountSeq", sequenceName="ACCOUNT_SEQ", allocationSize=1)
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="accountSeq")
	@Column(name="`account_id`")
	private Integer accountId;
	
	@NotNull
	@Column(name="`username`")
	private String username;
	@NotNull
	@Column(name="`hashed_password`")
	private String hashedPassword;
	@NotNull
	@Column(name="`email`")
	private String email;
	@NotNull
	@Column(name="`rank`")
	private Integer rank;
	
	public Account() {
		super();
	}

	public Account(String username, String hashedPassword, String email, Integer rank) {
		super();
		this.username = username;
		this.hashedPassword = hashedPassword;
		this.email = email;
		this.rank = rank;
	}

	public Integer getAccountId() {
		return accountId;
	}
	
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "{\n\t\"accountId\": " + accountId + ",\n\t\"username\": \"" + username
				+ "\",\n\t\"hashedPassword\": \"" + hashedPassword + "\",\n\t\"email\": \""
				+ email + "\"\n}";
	}
}