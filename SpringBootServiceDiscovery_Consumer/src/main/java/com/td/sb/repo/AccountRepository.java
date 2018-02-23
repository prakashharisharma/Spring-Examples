package com.td.sb.repo;

import java.util.List;

import com.td.sb.model.Account;

public interface AccountRepository {
	List<Account> getAllAccounts();
	
	Account getAccount(String number);
}
