package com.multi.multifin.account.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.account.model.mapper.AccountMapper;
import com.multi.multifin.account.model.vo.Account;
import com.multi.multifin.investedstock.model.vo.InvestedStock;

@Service
public class AccountService {
	
	@Autowired
	private AccountMapper mapper;
	
	public List<Account> getAccountList(Map<String, String> param) {
		return mapper.selectAccountList(param);
	}
	
	public int saveInvestedStock(Account account) {
		int result = 0;
		if (account.getANum() == 0) {
			result = mapper.insertAccount(account);
		}
		return result;
	}
}
