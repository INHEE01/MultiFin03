package com.multi.multifin.account.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.account.model.vo.Account;

@Mapper
public interface AccountMapper {
	List<Account> selectAccountList(Map<String, String> param);
	int insertAccount(Account account);
}
