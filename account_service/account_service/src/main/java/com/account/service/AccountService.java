package com.account.service;


import java.util.List;
import java.util.Optional;

import com.account.model.Account;

public interface AccountService {
	
	//Get all accounts of customer
	public List<Account> getAccountsOfCustomer(Long userId);
	//Get account
	Optional<Account> getAccount(Long accountId);
	//Add account
	Account addAccount(Account account);
	//update account
    Account updateAccount(Long accountId, Account account);
    //delete account
    void deleteAccount(Long accountId);
	

}
