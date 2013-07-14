package com.openfeed.backend.dao.marketentity;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.stocks.Companies;

/**
 * companies DAO Interface
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Sat Feb 19 19:17:34 EST 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public interface CompaniesDAO {

	/**
	 * Select Method
	 */
	public Companies select(String symbol, String exchange) throws RecordNotFoundException;
	
	
	/**
	 * 
	 * @param searchStr
	 * @return
	 */
	public List<Companies> searchCompany(String searchStr);
	
	public void insert(String symbol, String exchange,
			String companyName, String industry);
	
}