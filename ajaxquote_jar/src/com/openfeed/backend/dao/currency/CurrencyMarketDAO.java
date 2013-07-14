package com.openfeed.backend.dao.currency;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.currency.CurrencyMarket;
import com.openfeed.backend.vo.stocks.Companies;

/**
 * currency Market DAO Interface
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Sun Mar 20 11:54:36 EDT 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public interface CurrencyMarketDAO {

	/**
	 * Select Method
	 */
	public CurrencyMarket select(String symbol) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 */
	public CurrencyMarket insert(String symbol, String exchange, String description) throws DuplicateRecordException;
	
	/**
	 * Update Method
	 */
	public CurrencyMarket update(String symbol, String exchange, String description) throws RecordNotFoundException;
	
	/**
	 * Delete Method
	 */
	public void delete(String symbol);

	public List<CurrencyMarket> searchCurrency(String searchStr);
	
}