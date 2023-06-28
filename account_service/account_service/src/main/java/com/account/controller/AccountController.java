package com.account.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.account.model.Account;
import com.account.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	
	@RequestMapping("customer/{userID}")
	public List<Account> getAccounts(@PathVariable("userID") Long userID){
		return accountService.getAccountsOfCustomer(userID);
		
		
	}
	
	@GetMapping("/{accountId}")
    public Optional<Account> getAccount(@PathVariable("accountId") Long accountId) {
		return accountService.getAccount(accountId) ;
    }
	@PostMapping("/")
    public ResponseEntity<Account> addAccount(@RequestBody Account account) {
        Account createdAccount = accountService.addAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
	
	// PUT update an existing account
		@PutMapping("/{accountId}")
		public Account updateAccount(@PathVariable("accountId") Long accountId, @RequestBody Account account) {
			return this.accountService.updateAccount(accountId, account);
		}
		
		// DELETE delete an existing account
		@DeleteMapping("/{accountId}")
		public void deleteAccount(@PathVariable("accountId") Long accountId) {
			this.accountService.deleteAccount(accountId);
		}

}
