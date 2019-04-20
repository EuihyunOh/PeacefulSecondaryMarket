package psm.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import psm.bind.DataBinding;
import psm.commons.PageCriteria;
import psm.dao.MySqlTradeDao;

@Component("/trade/search.do")
public class TradeSearchController implements PsmController, DataBinding {

	MySqlTradeDao tradeDao;
	
	@Autowired
	public TradeSearchController setTradeDao(MySqlTradeDao tradeDao) {
		this.tradeDao = tradeDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[] {
				"search",String.class,
				"no", String.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		PageCriteria page = new PageCriteria();
		String keyword = (String)model.get("search");
		
		if(model.get("no")!="" && model.get("no")!=null) {
			Integer pageNo = Integer.parseInt((String)model.get("no"));
			page.setPage(pageNo);
			page.setPaginationStart(pageNo);
		}
		
		if(keyword==null) {
			keyword="";
		}
		
		model.put("trades",tradeDao.selectSearchList(keyword,page));
		model.put("no", page);
		return "/trade/TradeSearchResult.jsp";
	}


}
