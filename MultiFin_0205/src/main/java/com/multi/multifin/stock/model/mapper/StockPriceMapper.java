package com.multi.multifin.stock.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.StockPrice;


@Mapper
public interface StockPriceMapper {
	List<StockPrice> KospiList();
	List<StockPrice> KosdaqList();
	List<StockPrice> KospiRanking();
	List<StockPrice> KospiRankingTop();
	List<StockPrice> KosdaqRankingTop();
	List<StockPrice> KosdaqRanking();
	StockPrice selectListByno(int no);
	StockPrice selectListByname(String name);
	
}
