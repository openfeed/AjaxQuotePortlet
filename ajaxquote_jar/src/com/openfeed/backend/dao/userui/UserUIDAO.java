package com.openfeed.backend.dao.userui;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.userui.UserUI;

/**
 * widget Entity DAO Interface
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Thu Jun 06 20:48:53 EDT 2013<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public interface UserUIDAO {

	/**
	 * Select Method
	 */
	public UserUI select(long userUIId) throws RecordNotFoundException;
	
	public UserUI select(long userId, String uiId) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 */
	public UserUI insert(long userId, String uiId) throws DuplicateRecordException;
	
	/**
	 * Update Method
	 */
	public UserUI update(long userUIId, long userId, String uiId) throws RecordNotFoundException;
	
	/**
	 * Delete Method
	 */
	public void delete(long userUIId);
	
}