package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlTradeDao;
import psm.vo.Member;

@Component("/member/mylist.do")
public class MemberMyListController implements PsmController, DataBinding {
	MySqlTradeDao tradeDao;
	
	@Autowired
	public MemberMyListController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"trade",psm.vo.Trade.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Member member =	(Member)session.getAttribute("member");
		
		if(member!=null) {
		model.put("trades",tradeDao.selectOwnList(member.getId()));	
		model.put("trades2",tradeDao.selectBidList(member.getId()));
		return "/member/MyList.jsp";
		}else {
			return "redirect:../auth/signin.do";
		}		
		
	}

}
