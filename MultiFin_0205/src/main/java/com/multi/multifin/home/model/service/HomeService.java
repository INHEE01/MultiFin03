package com.multi.multifin.home.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.home.model.mapper.HomeMapper;
import com.multi.multifin.home.model.vo.Home;


@Service
public class HomeService {

	@Autowired(required=false)
	private HomeMapper mapper;

	public List<Home> searchRealEstate(Map<String, Object> map){
		return mapper.selectRealEstateList(map);
	}

	public List<Home> searchRealEstateByDong(Map<String, Object> map) {
		return mapper.selectRealEstateByDong(map);
	}

}
