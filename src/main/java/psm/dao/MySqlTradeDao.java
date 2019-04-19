package psm.dao;

import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psm.commons.PageCriteria;
import psm.vo.Trade;

@Repository("TradeDao")
public class MySqlTradeDao implements TradeDao {
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public List<Trade> selectList(PageCriteria page) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
						
			return sqlSession.selectList("psm.dao.TradeDao.selectList", page);
			
		}finally {
			sqlSession.close();
		}
		
	}
	
	@Override
	public List<Trade> selectOwnList(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			return sqlSession.selectList("psm.dao.TradeDao.selectOwnList",id);
			
		}finally {
			sqlSession.close();
		}
	}
	
	@Override
	public List<Trade> selectBidList(String dealId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			return sqlSession.selectList("psm.dao.TradeDao.selectBidList",dealId);
			
		}finally {
			sqlSession.close();
		}
	}


	@Override
	public int insert(Trade trade) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			int count = sqlSession.insert("psm.dao.TradeDao.insert",trade);
			sqlSession.commit();
			return count;
			
		}finally {
			sqlSession.close();
		}
		
	}

	@Override
	public Trade selectOne(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			return sqlSession.selectOne("psm.dao.TradeDao.selectOne",no);
			
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int updateContent(Trade trade) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			Trade original = sqlSession.selectOne("psm.dao.TradeDao.selectOne",trade.getNo());
			Hashtable<String,Object> paramMap = new Hashtable<String,Object>();
			
			if(!trade.getTitle().equals(original.getTitle())) {
				paramMap.put("title", trade.getTitle());
			}
			if(trade.getTradeName()!=original.getTradeName()) {
				paramMap.put("tradeName", trade.getTradeName());
			}
			if(trade.getPrice()!=original.getPrice()) {
				paramMap.put("price", trade.getPrice());
			}			
			if(trade.getCondition()!=original.getCondition()) {
				paramMap.put("condition", trade.getCondition());
			}
			if(!trade.getContent().equals(original.getContent())) {
				paramMap.put("content", trade.getContent());
			}							
			
			if(paramMap.size()>0) {
				paramMap.put("no",trade.getNo());
				int count = sqlSession.update("psm.dao.TradeDao.updateContent",paramMap);
				sqlSession.commit();
				return count;
			}else
				return 0;
			
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int updateState(int no, int state) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Hashtable<String, Integer> paramMap = new Hashtable<String, Integer>();
		paramMap.put("no", no);
		paramMap.put("state",state);
		
		try {
			
			int count = sqlSession.update("psm.dao.TradeDao.updateState",paramMap);
			sqlSession.commit();
			return count;
			
		}finally {
			sqlSession.close();
		}
		
	}

	@Override
	public int updateDealId(int no, String dealId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Hashtable<String, String> paramMap = new Hashtable<String, String>();
		paramMap.put("no", String.valueOf(no));
		paramMap.put("dealId",dealId);
		try {
			
			int count = sqlSession.update("psm.dao.TradeDao.updateDealId",paramMap);
			sqlSession.commit();
			return count;
			
		}finally {
			sqlSession.close();
		}
	}


}
