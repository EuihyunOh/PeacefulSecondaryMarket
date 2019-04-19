package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlMemberDao;
import psm.vo.Member;

@Component("/member/update.do")
public class MemberUpdateController implements PsmController, DataBinding {
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
		HttpSession session = (HttpSession)model.get("session");
		Member user = (Member)session.getAttribute("member");		
		Member member = (Member)model.get("member");
		
		if(user==null) {
			return "redirect:../auth/signin.do";
		}else {
			if(member.getId()==null) {
				String id = user.getId();
				model.put("member",memberDao.selectOne(id));
				return "/member/MemberUpdateForm.jsp";
			}else {
				memberDao.update(member);
				return "redirect:../trade/list.do";
			}
		
		}
	}

}
