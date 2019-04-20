package psm.dao;

import java.util.List;

import psm.commons.PageCriteria;
import psm.vo.Trade;

public interface TradeDao {
	List<Trade> selectList(PageCriteria page) throws Exception;
	List<Trade> selectOwnList(String id, PageCriteria page) throws Exception;
	List<Trade> selectBidList(String dealId, PageCriteria page) throws Exception;
	List<Trade> selectSearchList(String keyword, PageCriteria page) throws Exception;
	int insert(Trade trade) throws Exception;
	Trade selectOne(int no) throws Exception;
	int updateContent(Trade trade) throws Exception;
	int updateState(int no,int state) throws Exception;
	int updateDealId(int no, String dealId) throws Exception;
	//int delete(int no) throws Exception;
}
