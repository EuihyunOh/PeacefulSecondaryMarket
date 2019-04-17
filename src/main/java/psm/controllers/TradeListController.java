package psm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.dao.MySqlTradeDao;

@Component("/trade/list.do")
public class TradeListController implements Controller, DataBinding {
	MySqlTradeDao tradeDao;
	
	@Autowired
	public TradeListController setTradeDao(MySqlTradeDao tradeDao) {
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
		
		model.put("trades",tradeDao.selectList());
		return "/trade/TradeList.jsp";
	}

}
