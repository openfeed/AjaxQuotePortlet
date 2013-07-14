package com.openfeed.backend.dao.user;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.User;

/**
 * user DAO Interface
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Wed Mar 23 19:55:28 EDT 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public interface UserDAO {

	/**
	 * Select Method
	 */
	public User select(long userId) throws RecordNotFoundException;
	
	/**
	 * Select By username
	 * @param username
	 * @return
	 * @throws RecordNotFoundException
	 */
	public User selectByName(String username) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 */
	public User insert(String userName) throws DuplicateRecordException;
	
	/**
	 * Update Method
	 */
	public User update(long userId, String userName) throws RecordNotFoundException;
	
	/**
	 * Delete Method
	 */
	public void delete(long userId);
	
}