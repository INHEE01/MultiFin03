package com.multi.multifin.home.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.home.model.vo.Home;


@Mapper
public interface HomeMapper {

	List<Home> selectRealEstateList(Map<String, Object> map);
	List<Home> selectRealEstateByDong(Map<String, Object> map);

}
