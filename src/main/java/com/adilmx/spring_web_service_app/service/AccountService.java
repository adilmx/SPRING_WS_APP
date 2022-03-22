package com.adilmx.spring_web_service_app.service;

import java.util.List;

import com.adilmx.spring_web_service_app.entity.Account;


public interface AccountService {
	public Account saveAccount(Account account);
	public Account getAccount(Long id);
	public List<Account> getAllAccounts();
	public void virement(double mt,Long acc_src,long acc_dest);
}
