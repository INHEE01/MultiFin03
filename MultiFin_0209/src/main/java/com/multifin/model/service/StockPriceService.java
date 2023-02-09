package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.StockPriceDao;
import com.multifin.model.vo.StockPrice;

public class StockPriceService {
	private StockPriceDao dao = new StockPriceDao();
	private Connection conn = null;
	
	public StockPriceService() {
		conn = openConnection();
	}
	
	public List<StockPrice> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(StockPrice stockPrice) {
		int result = dao.insert(conn,  stockPrice);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
