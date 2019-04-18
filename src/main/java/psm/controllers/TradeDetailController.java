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

@Component("/trade/detail.do")
public class TradeDetailController implements Controller, DataBinding {
	MySqlTradeDao tradeDao;
	MySqlMemberDao memberDao;
	
	@Autowired
	public TradeDetailController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Autowired
	public TradeDetailController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"trade", psm.vo.Trade.class,
				"member", psm.vo.Member.class,
				"no", Integer.class,
				"isWriter", Boolean.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("TradeDetailController");
		HttpSession session = (HttpSession)model.get("session");
		Boolean isWriter = false;
		Integer no = (Integer)model.get("no"); //from number
		Trade trade = tradeDao.selectOne(no);
		Member member = memberDao.selectOne(trade.getId()); // get id -> find phone number
		Member signIn = (Member)session.getAttribute("member");
		if(signIn!=null) { // is there user in session?
			isWriter = signIn.getId().equals(trade.getId()); // is writer? if right, show update instead of deal
		}
		
		model.put("isWriter", isWriter);
		model.put("trade", trade);
		model.put("phone",member.getPhone());
		return "/trade/TradeDetail.jsp";
	}

}
