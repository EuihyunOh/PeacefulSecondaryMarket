package psm.dao;

import java.util.Hashtable;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import psm.vo.Member;

@Repository("MemberDao")
public class MySqlMemberDao implements MemberDao {
	SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	@Override
	public int insert(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			int count = sqlSession.insert("psm.dao.MemberDao.insert",member);
			sqlSession.commit();
			return count;
			
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public Member selectOne(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			return sqlSession.selectOne("psm.dao.MemberDao.selectOne",id);
			
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public int update(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			Member original = sqlSession.selectOne("psm.dao.MemberDao.selectOne",member.getId());
			Hashtable<String, Object> paramMap = new Hashtable<String,Object>();
			
			if(!member.getPassword().equals("")) {
				if(!member.getPassword().equals(original.getPassword())) {
					paramMap.put("password",member.getPassword());
				}				
			}
			if(!member.getAddress().equals(original.getAddress())) {
				paramMap.put("address", member.getAddress());
			}
			if(!member.getTradeName().equals(original.getTradeName())) {
				paramMap.put("tradeName", member.getTradeName());
			}
			if(!member.getAccount().equals(original.getAccount())) {
				paramMap.put("account", member.getAccount());
			}
			if(!member.getPhone().equals(original.getPhone())) {
				paramMap.put("phone", member.getPhone());
			}
			if(paramMap.size()>0) {
				paramMap.put("id",member.getId());
				int count = sqlSession.update("psm.dao.MemberDao.update",paramMap);
				sqlSession.commit();
				return count;
			}else
				return 0;
			
		}finally {
			sqlSession.close();
		}
	}

	@Override
	public Member exist(String id, String password) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		Hashtable<String,String> paramMap = new Hashtable<String,String>();
		paramMap.put("id",id);
		paramMap.put("password", password);
		try {
			
			return sqlSession.selectOne("psm.dao.MemberDao.exist",paramMap);
			
		}finally {
			sqlSession.close();
		}
		
	}

}
