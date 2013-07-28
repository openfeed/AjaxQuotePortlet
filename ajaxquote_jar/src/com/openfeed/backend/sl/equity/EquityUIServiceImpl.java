package com.openfeed.backend.sl.equity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openfeed.backend.common.IOpenfeedConstants;
import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.equity.EquityEntity;
import com.openfeed.backend.vo.equity.MarketEntity;
import com.openfeed.backend.vo.userui.UserUI;

/**
 * 
 * @author Master
 * 
 */
@Service("equityUIService")
public class EquityUIServiceImpl extends AbstractEquityUIService {

	public List<MarketEntity> getEquitiesByUserUIId(long uiId) {
		List<Long> list = userUIMarketEntityDAO.selectEntityIdByUserUIId(uiId);
		return marketEntityDAO.listByTypeUserId(
				IOpenfeedConstants.MARKET_ENTITY_EQUITY_TYPE, list);
	}

	@Transactional
	public void removeMarketEntity(long stockId) throws RecordNotFoundException {
		MarketEntity entity = marketEntityDAO.select(stockId);
		marketEntityDAO.delete(stockId);

	}

	@Transactional
	public MarketEntity addMarketEntity(String type, String symbol,
			String exchange, String companyName)
			throws DuplicateRecordException {
		MarketEntity stock = marketEntityDAO.insert(type, symbol, exchange,
				companyName);
		return stock;
	}

	@Override
	public List<EquityEntity> searchEquity(String symbol) {
		return equityEntityDAO.searchEntity(symbol);
	}

	@Override
	public boolean isSybolDuplicate(String symbol) {
		boolean result = false;
		try {
			marketEntityDAO.selectBySymbol(symbol);
			result = true;
		} catch (RecordNotFoundException e) {
		}
		return result;
	}


	@Transactional
	public UserUI addUserUI(long userId, String uiId) {
		UserUI userui = null;
		try {
			userui = userUIDAO.select(userId, uiId);
		} catch (RecordNotFoundException e) {
			try {
				userui = userUIDAO.insert(userId, uiId);
			} catch (DuplicateRecordException e1) {
			}
		}
		return userui;
	}

	@Transactional
	public void addEquityEntity(String symbol, String exchange,
			String companyName, String industry) {
		
		equityEntityDAO.insert(symbol, exchange, companyName, industry);
	}

}