package com.multi.multifin.stock.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.FundProductInfo;

@Mapper
public interface FundProductInfoMapper {
	List<FundProductInfo> selectFundProduct(Map<String, String> map); // 펀드상품 리스트 출력
	int selectFundCount(Map<String, String> map); // 펀드 리스트의 개수
}
