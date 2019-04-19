package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.commons.PageCriteria;
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
				"trade",psm.vo.Trade.class,
				"t1", String.class,
				"t2", String.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Member member =	(Member)session.getAttribute("member");
		PageCriteria t1Page = new PageCriteria();
		PageCriteria t2Page = new PageCriteria();
		
		if(model.get("t1")!=null && model.get("t2")!=null) {
			Integer t1 = Integer.parseInt((String)model.get("t1"));
			Integer t2 = Integer.parseInt((String)model.get("t2"));
			
			t1Page.setPage(t1);
			t1Page.setPaginationStart(t1);
			t2Page.setPage(t2);
			t2Page.setPaginationStart(t2);
		}
		
		if(member!=null) {
		model.put("trades",tradeDao.selectOwnList(member.getId(),t1Page));	
		model.put("trades2",tradeDao.selectBidList(member.getId(),t2Page));
		model.put("t1",t1Page);
		model.put("t2", t2Page);
		return "/member/MyList.jsp";
		}else {
			return "redirect:../auth/signin.do";
		}		
		
	}

}
