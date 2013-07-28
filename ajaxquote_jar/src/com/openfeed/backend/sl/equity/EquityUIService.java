package com.openfeed.backend.sl.equity;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.equity.EquityEntity;
import com.openfeed.backend.vo.equity.MarketEntity;
import com.openfeed.backend.vo.userui.UserUI;

/**
 * 
 * @author yablons 
 * @author jb
 * 
 */
public interface EquityUIService {

	public List<MarketEntity> getEquitiesByUserUIId(long uiId);
	
	public UserUI addUserUI(long userId, String uiId);
	
	public void removeMarketEntity(long stockId) throws RecordNotFoundException;

	public MarketEntity addMarketEntity(String type, String symbol, String exchange, String companyName)
			throws DuplicateRecordException;

	public List<EquityEntity> searchEquity(String searchStr);
	
	public boolean isSybolDuplicate(String symbol);
	
	public void addEquityEntity(String symbol, String exchange, String companyName, String industry);
}
