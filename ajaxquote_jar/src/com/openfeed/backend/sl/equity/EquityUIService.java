package com.openfeed.backend.sl.equity;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.currency.CurrencyMarket;
import com.openfeed.backend.vo.stocks.Companies;
import com.openfeed.backend.vo.stocks.MarketEntity;
import com.openfeed.backend.vo.widget.WidgetEntity;

/**
 * 
 * @author yablons 
 * @author jb
 * 
 */
public interface EquityUIService {

	public List<MarketEntity> getEquitiesByUserUIId(long uiId);
	
	public WidgetEntity addWidgetEntity(long userId, String uiId);
	
	public List<MarketEntity> getCurrenciesByUserId(long userId);

	public List<MarketEntity> getIndexesByUserId(long userId);
	
	public List<MarketEntity> getMarketEntityList();
	
	public void removeMarketEntity(long stockId) throws RecordNotFoundException;

	public MarketEntity addMarketEntity(String type, String symbol, String exchange, String companyName)
			throws DuplicateRecordException;

	public List<Companies> searchCompanies(String searchStr);
	
	public List<CurrencyMarket> searchCurrencies(String searchStr);

	public boolean isSybolDuplicate(String symbol);
	
	public List<MarketEntity> getMarketEntityListByUserId(long userId);
	
	public void addEquityEntity(String symbol, String exchange, String companyName, String industry);
}
