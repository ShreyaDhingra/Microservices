package com.account.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.model.Account;



@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
	List<Account> findByUserID(Long userId);

}


