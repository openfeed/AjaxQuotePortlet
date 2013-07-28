package com.openfeed.backend.dao.marketentity;

import java.util.List;

import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.equity.EquityEntity;

public interface EquityEntityDAO {

	/**
	 * Select Method
	 */
	public EquityEntity select(String symbol, String exchange) throws RecordNotFoundException;
	
	
	/**
	 * 
	 * @param searchStr
	 * @return
	 */
	public List<EquityEntity> searchEntity(String searchStr);
	
	public void insert(String symbol, String exchange,
			String companyName, String industry);
	
}