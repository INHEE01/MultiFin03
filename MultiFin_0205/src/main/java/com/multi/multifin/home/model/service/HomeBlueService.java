package com.multi.multifin.home.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.home.model.mapper.HomeBlueMapper;
import com.multi.multifin.home.model.vo.Aptdetail;
import com.multi.multifin.home.model.vo.OfficeDetail;
import com.multi.multifin.home.model.vo.RemainDetail;

@Service
public class HomeBlueService {
	
	@Autowired(required=false)
	private HomeBlueMapper mapper;
	
	public List<Aptdetail> searchAptList(Map<String, String> map){
		return mapper.searchAptList(map);
	}
		
	public List<OfficeDetail> searchOfficeList(Map<String, String> map){
		return mapper.searchOfficeList(map);
	}
	
	public List<RemainDetail> searchRemainList(Map<String, String> map){
		return mapper.searchRemainList(map);
	}
	
	

}
