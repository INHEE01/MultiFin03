package com.multi.multifin.home.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.home.model.mapper.HomeMapper;
import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;


@Service
public class HomeService {

	@Autowired(required=false)
	private HomeMapper mapper;

	public List<Home> searchHomeList(Map<String, Object> map){
		return mapper.selectHomeList(map);
	}

	public List<Home> searchHomeByDong(Map<String, Object> param) {
		return mapper.selectHomeByDong(param);
	}
	
	public List<MarkerParsing> selectHomeByXY() {
		return mapper.selectHomeByXY();
	}

}
