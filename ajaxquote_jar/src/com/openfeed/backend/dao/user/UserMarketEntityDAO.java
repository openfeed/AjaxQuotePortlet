package com.openfeed.backend.dao.user;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.UserMarketEntity;

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
public interface UserMarketEntityDAO {

	/**
	 * Select Method
	 * @param entityId TODO
	 */
	public UserMarketEntity select(long userId, long entityId) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 * @param entityId TODO
	 */
	public UserMarketEntity insert(long userId, long entityId) throws DuplicateRecordException;
	
	/**
	 * Delete Method
	 * @param entityId TODO
	 */
	public void delete(long userId, long entityId);

	public List<UserMarketEntity> selectByEntityId(long entityId);

	public List<UserMarketEntity> selectByUserId(long userId);

	public List<Long> selectEntityIdByWidgetUserId(long uiId);
	

}