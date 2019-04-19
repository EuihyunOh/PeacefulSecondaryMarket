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
				"no", String.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		PageCriteria page = new PageCriteria();
		if(model.get("no")!="" && model.get("no")!=null) {
			Integer pageNo = Integer.parseInt((String)model.get("no"));
			page.setPage(pageNo);
			page.setPaginationStart(pageNo);
			System.out.println(page.getPaginationStart());
		}		
		model.put("trades",tradeDao.selectList(page));
		model.put("no", page);
		return "/trade/TradeList.jsp";
	}

}
