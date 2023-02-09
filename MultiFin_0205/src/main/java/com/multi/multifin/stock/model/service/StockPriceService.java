package com.multi.multifin.stock.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.stock.model.mapper.ExchangeRateMapper;
import com.multi.multifin.stock.model.mapper.FundProductInfoMapper;
import com.multi.multifin.stock.model.mapper.StockPriceIndexMapper;
import com.multi.multifin.stock.model.mapper.StockPriceMapper;
import com.multi.multifin.stock.model.vo.ExchangeRate;
import com.multi.multifin.stock.model.vo.FundProductInfo;
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
	
	@Autowired
	private FundProductInfoMapper fpMapper;
	
	

	public List<StockPrice> getStockList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectStockList(param);
	}
	
	public int getStockCount(Map<String, String> param) {
		return mapper.selectStockCount(param);
	}
	
	
	
	
	
	
	public List<StockPrice> getKospiList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.KospiList(param);
	}
	
	public List<StockPrice> getKosdaqList(PageInfo pageInfo, Map<String, String> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.KosdaqList(param);
	}

	public List<StockPrice> getKospiRankingTop(Map<String, String> param){
		return mapper.KospiRankingTop(param);
	}
	
	public List<StockPrice> getKosdaqRankingTop(Map<String, String> param){
		return mapper.KosdaqRankingTop(param);
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
	
	// 펀드 리스트 출력
	public List<FundProductInfo> getFundList(PageInfo pageInfo, Map<String, String> param) {
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		
		return fpMapper.selectFundProduct(param);
	}
	
	// 펀드 리스트의 개수
	public int getFundCount(Map<String, String> param) {
		return fpMapper.selectFundCount(param);
	}

}
