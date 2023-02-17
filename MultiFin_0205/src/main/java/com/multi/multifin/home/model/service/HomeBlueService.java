package com.multi.multifin.home.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.home.model.mapper.HomeBlueMapper;
import com.multi.multifin.home.model.vo.Aptdetail;
import com.multi.multifin.home.model.vo.OfficeDetail;
import com.multi.multifin.home.model.vo.RemainDetail;

@Service
public class HomeBlueService {
	
	@Autowired
	private HomeBlueMapper mapper;
	
	public List<Aptdetail> searchAptList(PageInfo pageInfo, Map<String, String> map){
		map.put("limit", "" + pageInfo.getListLimit());
		map.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.searchAptList(map);
	}
		
	public int selectAptCount(Map<String, String> param) {
		return mapper.selectAptCount(param);
	}
	
	public List<OfficeDetail> searchOfficeList(PageInfo pageInfo, Map<String, String> map){
		map.put("limit", "" + pageInfo.getListLimit());
		map.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.searchOfficeList(map);
	}
	
	public int selectOfficeCount(Map<String, String> param) {
		return mapper.selectOfficeCount(param);
	}
	
	public List<RemainDetail> searchRemainList(PageInfo pageInfo, Map<String, String> map){
		map.put("limit", "" + pageInfo.getListLimit());
		map.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.searchRemainList(map);
	}
	
	public int selectRemainCount(Map<String, String> param) {
		return mapper.selectRemainCount(param);
	}
	
	

}
