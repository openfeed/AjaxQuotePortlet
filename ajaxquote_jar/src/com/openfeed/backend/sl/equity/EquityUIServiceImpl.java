package com.openfeed.backend.sl.equity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openfeed.backend.common.IOpenfeedConstants;
import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.currency.CurrencyMarket;
import com.openfeed.backend.vo.stocks.Companies;
import com.openfeed.backend.vo.stocks.MarketEntity;
import com.openfeed.backend.vo.widget.WidgetEntity;

/**
 * 
 * @author Master
 * 
 */
@Service("equityUIService")
public class EquityUIServiceImpl extends AbstractEquityUIService {

	public List<MarketEntity> getEquitiesByUserUIId(long uiId) {
		List<Long> list = userMarketEntityDAO.selectEntityIdByWidgetUserId(uiId);
		return marketEntityDAO.listByTypeUserId(
				IOpenfeedConstants.MARKET_ENTITY_EQUITY_TYPE, list);
	}

	@Override
	public List<MarketEntity> getCurrenciesByUserId(long userId) {
		List<Long> list = userMarketEntityDAO.selectEntityIdByWidgetUserId(userId);
		return marketEntityDAO.listByTypeUserId(
				IOpenfeedConstants.MARKET_ENTITY_CURRENCY_TYPE, list);
	}

	@Override
	public List<MarketEntity> getIndexesByUserId(long userId) {
		List<Long> list = userMarketEntityDAO.selectEntityIdByWidgetUserId(userId);
		return marketEntityDAO.listByTypeUserId(
				IOpenfeedConstants.MARKET_ENTITY_INDEX_TYPE, list);
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
	public List<Companies> searchCompanies(String symbol) {
		return companiesDAO.searchCompany(symbol);
	}

	@Override
	public List<CurrencyMarket> searchCurrencies(String searchStr) {
		return currencyMarketDAO.searchCurrency(searchStr);
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

	@Override
	public List<MarketEntity> getMarketEntityList() {
		return marketEntityDAO.list();
	}

	@Override
	public List<MarketEntity> getMarketEntityListByUserId(long userId) {
		return marketEntityDAO.listByUserId(userId);
	}

	@Transactional
	public WidgetEntity addWidgetEntity(long userId, String uiId) {
		WidgetEntity widgetEntity = null;
		try {
			widgetEntity = widgetEntityDAO.select(userId, uiId);
		} catch (RecordNotFoundException e) {
			try {
				widgetEntity = widgetEntityDAO.insert(userId, uiId);
			} catch (DuplicateRecordException e1) {
			}
		}
		return widgetEntity;
	}

	@Transactional
	public void addEquityEntity(String symbol, String exchange,
			String companyName, String industry) {
		
		companiesDAO.insert(symbol, exchange, companyName, industry);
	}

}