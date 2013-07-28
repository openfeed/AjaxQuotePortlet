package com.openfeed.backend.dao.marketentity;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.equity.MarketEntity;

/**
 * DAO Interface
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Tue Feb 22 19:03:28 EST 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public interface MarketEntityDAO {

	/**
	 * Select Method
	 */
	public MarketEntity select(long stockId) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 * @param type TODO
	 */
	public MarketEntity insert(String type, String symbol, String exchange, String companyName) throws DuplicateRecordException;
	
	/**
	 * Update Method
	 * @param type TODO
	 */
	public MarketEntity update(long stockId, String type, String symbol, String exchange, String companyName) throws RecordNotFoundException;
	
	
	/**
	 * Delete Method
	 */
	public void delete(long stockId);
	
	public List<MarketEntity> list();

	public MarketEntity selectBySymbol(String symbol) throws RecordNotFoundException;
	
	public List<MarketEntity> listByTypeUserId(String type, List<Long> entityIds);
	
	public List<MarketEntity> listByUserId(long userId);
	
}