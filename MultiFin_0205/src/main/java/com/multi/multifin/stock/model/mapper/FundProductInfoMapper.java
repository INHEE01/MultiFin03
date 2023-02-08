package com.multi.multifin.stock.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.stock.model.vo.FundProductInfo;

@Mapper
public interface FundProductInfoMapper {
	List<FundProductInfo> selectFundProduct(); // 펀드상품 리스트 출력
}
