package psm.controllers;

import java.util.Map;

import org.springframework.stereotype.Component;

import psm.bind.DataBinding;

@Component("/trade/list.do")
public class TradeListController implements Controller, DataBinding {
	//MySqlTradeDao tradeDao;
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		
		return "/trade/TradeList.jsp";
	}

}
