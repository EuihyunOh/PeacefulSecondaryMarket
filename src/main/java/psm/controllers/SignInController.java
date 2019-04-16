package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlMemberDao;
import psm.vo.Member;

@Component("/auth/signin.do")
public class SignInController implements Controller, DataBinding {
	MySqlMemberDao memberDao;
	
	@Autowired
	public SignInController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"loginInfo", psm.vo.Member.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		Member loginInfo = (Member)model.get("loginInfo");
		
		if(loginInfo.getId()==null) {
			return "/auth/SignIn.jsp";
		}else {
			Member member = memberDao.exist(loginInfo.getId(), loginInfo.getPassword());
			if(member.getId()!=null) {
				HttpSession session = (HttpSession)model.get("session");
				session.setAttribute("member",member);
				return "redirect:../trade/list.do";
			}else {
				return "/auth/LogInFail.jsp";
			}
		}
	}
	

}
