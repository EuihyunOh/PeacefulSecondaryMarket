package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlTradeDao;
import psm.vo.Member;

@Component("/state/dealrequest.do")
public class DealRequestService implements Controller, DataBinding {
MySqlTradeDao tradeDao;
	
	@Autowired
	public DealRequestService setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"no", Integer.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("DealRequest");
		HttpSession session = (HttpSession)model.get("session");
		Member member = (Member)session.getAttribute("member");
		Integer no = (Integer)model.get("no");
		String dealId = member.getId();
		System.out.println(dealId);
		
		tradeDao.updateDealId(no,dealId);
		return "redirect:../member/mylist.do";
		
	}
}
