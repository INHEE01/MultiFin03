package com.multi.multifin.home.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.multi.multifin.home.model.vo.Aptdetail;
import com.multi.multifin.home.model.vo.OfficeDetail;
import com.multi.multifin.home.model.vo.RemainDetail;

@Mapper
public interface HomeBlueMapper {
	
	List<Aptdetail> searchAptList(Map<String, String> map);
	List<OfficeDetail> searchOfficeList(Map<String, String> map);
	List<RemainDetail> searchRemainList(Map<String, String> map);
}
