package psm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import psm.bind.DataBinding;
import psm.dao.MySqlMemberDao;

public class MemberUpdateController implements Controller, DataBinding {
	MySqlMemberDao memberDao;
	
	@Autowired
	public MemberUpdateController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"member",psm.vo.Member.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
