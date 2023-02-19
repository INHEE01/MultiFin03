package com.multi.multifin.investedstock.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.multifin.investedstock.model.mapper.InvestedStockMapper;
import com.multi.multifin.investedstock.model.vo.InvestedStock;

@Service
public class InvestedStockService {
	
	@Autowired
	private InvestedStockMapper mapper;
	
	public List<InvestedStock> getInvestedStockList(Map<String, String> param) {
		return mapper.selectInvestedStockList(param);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int saveInvestedStock(InvestedStock investedStock) {
		int result = 0;
		if (investedStock.getOrderNum() == 0) {
			result = mapper.insertInvestedStock(investedStock);
		}
		return result;
	}
	
	
	
}
