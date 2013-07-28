package com.openfeed.backend.sl.equity;

import org.springframework.beans.factory.annotation.Autowired;

import com.openfeed.backend.dao.marketentity.EquityEntityDAO;
import com.openfeed.backend.dao.marketentity.MarketEntityDAO;
import com.openfeed.backend.dao.user.UserUIMarketEntityDAO;
import com.openfeed.backend.dao.userui.UserUIDAO;



public abstract class AbstractEquityUIService implements EquityUIService {
	
	protected MarketEntityDAO marketEntityDAO;
	
	protected EquityEntityDAO equityEntityDAO;
	
	protected UserUIDAO userUIDAO;
	
	protected UserUIMarketEntityDAO userUIMarketEntityDAO;

	@Autowired
	public void setMarketEntityDAO(MarketEntityDAO marketEntityDAO) {
		this.marketEntityDAO = marketEntityDAO;
	}

	@Autowired
	public void setEquityEntityDAO(EquityEntityDAO equityEntityDAO) {
		this.equityEntityDAO = equityEntityDAO;
	}

	@Autowired
	public void setUserUIDAO(UserUIDAO userUIDAO) {
		this.userUIDAO = userUIDAO;
	}

	@Autowired
	public void setUserUIMarketEntityDAO(UserUIMarketEntityDAO userUIMarketEntityDAO) {
		this.userUIMarketEntityDAO = userUIMarketEntityDAO;
	}

	
	
	
}
