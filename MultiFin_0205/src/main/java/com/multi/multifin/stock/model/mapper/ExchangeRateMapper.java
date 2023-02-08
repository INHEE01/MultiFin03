package com.multi.multifin.stock.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.ExchangeRate;

@Mapper
public interface ExchangeRateMapper {
	
	List<ExchangeRate> KosdaqRanking();
	ExchangeRate findByName(String name);
}
