package psm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.commons.PageCriteria;
import psm.dao.MySqlTradeDao;

@Component("/trade/list.do")
public class TradeListController implements PsmController, DataBinding {
	MySqlTradeDao tradeDao;
	
	@Autowired
	public TradeListController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"trade",psm.vo.Trade.class,
				"pageNo", String.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		System.out.println("TradeListController");
		PageCriteria page = new PageCriteria();
		
		if(model.get("pageNo")!="" && model.get("pageNo")!=null) {
			System.out.println("잡아옴");
			Integer pageNo = Integer.parseInt((String)model.get("pageNo"));
			page.setPage(pageNo);
		}
		
		model.put("trades",tradeDao.selectList(page));
		return "/trade/TradeList.jsp";
	}

}
