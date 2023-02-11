package com.multi.multifin.home.model.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;


@Mapper
public interface HomeMapper {

	List<Home> selectHomeList(Map<String, Object> map);
	List<Home> selectHomeByDong(Map<String, Object> map);
	List<MarkerParsing> selectHomeByXY();

}
