package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.model.dao.FundProductInfoDao;
import com.multifin.model.vo.FundProductInfo;

public class FundProductInfoService {
	private FundProductInfoDao dao = new FundProductInfoDao();
	private Connection conn = null;
	
	public FundProductInfoService() {
		conn = openConnection();
	}
	
	public int insert(FundProductInfo fundProductInfo) {
		int result = dao.insert(conn, fundProductInfo);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
}
