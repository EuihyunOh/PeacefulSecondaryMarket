package psm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlMemberDao;
import psm.vo.Member;

@Component("/member/signup.do")
public class SignUpController implements Controller, DataBinding {
	MySqlMemberDao memberDao;
	
	@Autowired
	public SignUpController setMemberDao(MySqlMemberDao memberDao) {
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
		Member member = (Member)model.get("member");
		
		if(member.getId()==null) {
			return "/member/SignUpForm.jsp";
		}else {
			memberDao.insert(member);
			return "redirect:../trade/list.do";
		}
	}

}
