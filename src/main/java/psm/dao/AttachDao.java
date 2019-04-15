package psm.dao;

import psm.vo.Attach;

public interface AttachDao {
	int insert(Attach attach) throws Exception;
	Attach selectOne(int tradeNo) throws Exception;
}
