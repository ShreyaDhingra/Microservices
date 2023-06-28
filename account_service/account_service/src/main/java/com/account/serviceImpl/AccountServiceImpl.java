package com.account.serviceImpl;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.model.Account;
import com.account.repo.AccountRepo;
import com.account.service.AccountService;
import com.account.exception.ResourceNotFound;



@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private AccountRepo accountRepo;
	
	
	//List of Accounts
	List<Account> accounts;
	

	@Override
	public List<Account> getAccountsOfCustomer(Long userID) {
	    return accountRepo.findByUserID(userID);
	}
	
	@Override
    public Optional<Account> getAccount(Long accountId) {
        return accountRepo.findById(accountId);
    }

    @Override
    public Account addAccount(Account account) {
        accountRepo.save(account);
        return account;
    }
    @Override
    public Account updateAccount(Long accountId, Account account) {
    	Account existingAcc = accountRepo.findById(accountId).orElseThrow(() -> new ResourceNotFound("Account", "accountId", accountId));
        existingAcc = account;
    	accountRepo.save(existingAcc);
        return existingAcc;
    }

    @Override
    public void deleteAccount(Long accountId) {
    	accountRepo.findById(accountId).orElseThrow(() -> new ResourceNotFound("Account", "accountId", accountId));
        accountRepo.deleteById(accountId);
        
    }

}
