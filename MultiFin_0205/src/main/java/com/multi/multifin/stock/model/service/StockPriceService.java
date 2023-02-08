package com.multi.multifin.stock.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.multifin.stock.model.mapper.ExchangeRateMapper;
import com.multi.multifin.stock.model.mapper.StockPriceIndexMapper;
import com.multi.multifin.stock.model.mapper.StockPriceMapper;
import com.multi.multifin.stock.model.vo.ExchangeRate;
import com.multi.multifin.stock.model.vo.StockPrice;
import com.multi.multifin.stock.model.vo.StockPriceIndex;

@Service
public class StockPriceService {
	@Autowired	
	private StockPriceMapper mapper;
	@Autowired
	private ExchangeRateMapper erMapper;
	@Autowired
	private StockPriceIndexMapper spiMapper;
	
	
	public List<StockPrice> getKospiList(){
		return mapper.KospiList();
	}
	
	public List<StockPrice> getKosdaqList(){
		return mapper.KosdaqList();
	}
	
	public List<StockPrice> getKospiRanking(){
		return mapper.KospiRanking();
	}
	
	public List<StockPrice> getKosdaqRanking(){
		return mapper.KosdaqRanking();
	}

	public List<StockPrice> getKospiRankingTop(){
		return mapper.KospiRankingTop();
	}
	
	public List<StockPrice> getKosdaqRankingTop(){
		return mapper.KosdaqRankingTop();
	}

	@Transactional(rollbackFor = Exception.class)
	public StockPrice findByNo(int stockNo) {
		StockPrice sp = mapper.selectListByno(stockNo);
		return sp;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public StockPrice findByName(String name) {
		StockPrice sp = mapper.selectListByname(name);
		return sp;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public ExchangeRate findExchangeRate(String name) {
		ExchangeRate er = erMapper.findByName(name);
		return er;
	}
	

	public List<StockPriceIndex> getStockList(String name){
		return spiMapper.getStockList(name);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public StockPriceIndex getnowStockIndex(String name) {
		StockPriceIndex si = spiMapper.nowStockIndex(name);
		return si;
	}
	
	public List<StockPriceIndex> currentStockList(String name){
		return spiMapper.currentStockList(name);
	}

}
