package com.openfeed.backend.sl.equity;

import org.springframework.beans.factory.annotation.Autowired;

import com.openfeed.backend.dao.currency.CurrencyMarketDAO;
import com.openfeed.backend.dao.marketentity.CompaniesDAO;
import com.openfeed.backend.dao.marketentity.MarketEntityDAO;
import com.openfeed.backend.dao.user.UserMarketEntityDAO;
import com.openfeed.backend.dao.widget.WidgetEntityDAO;



public abstract class AbstractEquityUIService implements EquityUIService {
	
	protected MarketEntityDAO marketEntityDAO;
	
	protected CompaniesDAO companiesDAO;
	
	protected CurrencyMarketDAO currencyMarketDAO;
	
	protected WidgetEntityDAO widgetEntityDAO;
	
	protected UserMarketEntityDAO userMarketEntityDAO;

	@Autowired
	public void setMarketEntityDAO(MarketEntityDAO stockDAO) {
		this.marketEntityDAO = stockDAO;
	}

	@Autowired
	public void setCompaniesDAO(CompaniesDAO companiesDAO) {
		this.companiesDAO = companiesDAO;
	}

	//@Autowired
	public void setCurrencyMarketDAO(CurrencyMarketDAO currencyMarketDAO) {
		this.currencyMarketDAO = currencyMarketDAO;
	}

	@Autowired
	public void setWidgetEntityDAO(WidgetEntityDAO widgetEntityDAO) {
		this.widgetEntityDAO = widgetEntityDAO;
	}

	public void setUserMarketEntityDAO(UserMarketEntityDAO userMarketEntityDAO) {
		this.userMarketEntityDAO = userMarketEntityDAO;
	}
	
	
}
