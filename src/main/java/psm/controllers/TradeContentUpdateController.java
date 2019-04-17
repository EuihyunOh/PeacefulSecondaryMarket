package psm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import psm.bind.DataBinding;
import psm.dao.MySqlMemberDao;
import psm.dao.MySqlTradeDao;
import psm.vo.Member;
import psm.vo.Trade;

public class TradeContentUpdateController implements Controller, DataBinding {
	MySqlTradeDao tradeDao;
	MySqlMemberDao memberDao;
	
	@Autowired
	public TradeContentUpdateController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	public TradeContentUpdateController setMemberDao(MySqlMemberDao memberDao) {
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
		
		Trade trade = (Trade)model.get("trade");
		Member member = (Member)model.get("member");
		
		if(trade.getTitle()==null) {
			return "/trade/TradeForm.jsp";
		}else {
			tradeDao.insert(trade);
			return "redirect:list.do";
		}
	}

}
