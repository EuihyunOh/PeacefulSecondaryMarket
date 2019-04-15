package psm.dao;

import psm.vo.Member;

public interface MemberDao {
	int insert(Member member) throws Exception;
//	int delete(int no) throws Exception; 
	Member selectOne(int no) throws Exception;
	int update(Member member) throws Exception;
	Member exist(String id, String password) throws Exception; // for login
}
