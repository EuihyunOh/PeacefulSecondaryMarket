package psm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psm.vo.Attach;

@Repository("AttachDao")
public class MySqlAttachDao implements AttachDao {
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insert(Attach attach) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			int count = sqlSession.insert("psm.dao.AttachDao.insert",attach);
			sqlSession.commit();
			return count;
			
		}finally {
			sqlSession.close();
		}
		
	}

	@Override
	public Attach selectOne(int tradeNo) throws Exception {
SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			return sqlSession.selectOne("psm.dao.AttachDao.insert",tradeNo);
			
		}finally {
			sqlSession.close();
		}
	}

}
