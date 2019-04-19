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

@Component("/trade/update.do")
public class TradeContentUpdateController implements PsmController, DataBinding {
	MySqlTradeDao tradeDao;
	MySqlMemberDao memberDao;
	
	@Autowired
	public TradeContentUpdateController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Autowired
	public TradeContentUpdateController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"trade", psm.vo.Trade.class,
				"phone", String.class,
				"no", Integer.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Integer no = (Integer)model.get("no");
		Trade origin = tradeDao.selectOne(no);
		Trade trade = (Trade)model.get("trade");
		Member member = (Member)session.getAttribute("member");
		
		if(member.getId().equals(origin.getId())) { // prevent access from url
			System.out.println("pass");
			if(trade.getTitle()==null) {			
				
				model.put("phone", member.getPhone());
				model.put("trade", origin);
				return "/trade/TradeUpdate.jsp";
			}else {
				tradeDao.updateContent(trade);
				return "redirect:detail.do?no="+String.valueOf(no);
			}
		}else {
			return "redirect:../Error.jsp";
		}
	}

}
