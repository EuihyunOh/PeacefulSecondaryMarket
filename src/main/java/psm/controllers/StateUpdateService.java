package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlTradeDao;
import psm.vo.Member;
import psm.vo.Trade;

@Component("/state/update.do")
public class StateUpdateService implements Controller, DataBinding{
	MySqlTradeDao tradeDao;
	
	@Autowired
	public StateUpdateService setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"no", Integer.class,
				"state", Integer.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		Member member = (Member)session.getAttribute("member");
		Integer no = (Integer)model.get("no");
		Integer state = (Integer)model.get("state");
		Trade trade = tradeDao.selectOne(no);
		
		if(trade.getId().equals(member.getId())||trade.getDealId().equals(member.getId())) {
			tradeDao.updateState(no,state);
			return "redirect:../member/mylist.do";
		}else {
			return "redirect:../Error.jsp";
		}
		
	}

	

}
