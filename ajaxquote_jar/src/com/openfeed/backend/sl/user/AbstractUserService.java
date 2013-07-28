package com.openfeed.backend.sl.user;

import org.springframework.beans.factory.annotation.Autowired;

import com.openfeed.backend.dao.marketentity.MarketEntityDAO;
import com.openfeed.backend.dao.user.UserDAO;
import com.openfeed.backend.dao.user.UserUIMarketEntityDAO;
import com.openfeed.backend.sl.equity.EquityUIService;

public abstract class AbstractUserService implements UserService {

	protected UserDAO userDAO;
	
	protected UserUIMarketEntityDAO userUIMarketEntityDAO;
	
	protected MarketEntityDAO marketEntityDAO;
	
	EquityUIService equityUIService;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Autowired
	public void setUserUIMarketEntityDAO(UserUIMarketEntityDAO userUIMarketEntityDAO) {
		this.userUIMarketEntityDAO = userUIMarketEntityDAO;
	}

	public void setMarketEntityDAO(MarketEntityDAO marketEntityDAO) {
		this.marketEntityDAO = marketEntityDAO;
	}

	@Autowired
	public void setEquityUIService(EquityUIService equityUIService) {
		this.equityUIService = equityUIService;
	}

}
