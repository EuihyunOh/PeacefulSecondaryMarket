package psm.dao;

import java.util.List;

import psm.vo.Trade;

public interface TradeDao {
	List<Trade> selectList() throws Exception;
	int insert(Trade trade) throws Exception;
	Trade selectOne(int no) throws Exception;
	int update(Trade trade) throws Exception;
	//int delete(int no) throws Exception;
}
