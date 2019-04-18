package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlMemberDao;
import psm.dao.MySqlTradeDao;
import psm.vo.Member;
import psm.vo.Trade;

@Component("/trade/write.do")
public class TradeAddController implements Controller, DataBinding {
	MySqlTradeDao tradeDao;
	MySqlMemberDao memberDao;
	
	@Autowired
	public TradeAddController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Autowired
	public TradeAddController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"trade", psm.vo.Trade.class,
				"member", psm.vo.Member.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("TradeAddController");
		HttpSession session = (HttpSession)model.get("session");
		Trade trade = (Trade)model.get("trade");
		Member member = (Member)session.getAttribute("member");
		trade.setId(member.getId());
		
		if(trade.getTitle()==null) {
			model.put("member", memberDao.selectOne(member.getId()));			
			return "/trade/TradeForm.jsp";
		}else {
			tradeDao.insert(trade);
			return "redirect:list.do";
		}
	}

}
