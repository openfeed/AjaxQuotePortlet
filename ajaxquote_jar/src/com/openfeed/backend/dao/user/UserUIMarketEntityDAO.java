package com.openfeed.backend.dao.user;

import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.UserUIMarketEntity;

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
public interface UserUIMarketEntityDAO {

	/**
	 * Select Method
	 * @param entityId TODO
	 */
	public UserUIMarketEntity select(long userUIId, long entityId) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 * @param entityId TODO
	 */
	public UserUIMarketEntity insert(long userUIId, long entityId) throws DuplicateRecordException;
	
	/**
	 * Delete Method
	 * @param entityId TODO
	 */
	public void delete(long userUIId, long entityId);

	public List<UserUIMarketEntity> selectByEntityId(long entityId);

	public List<UserUIMarketEntity> selectByUserUIId(long userUIId);

	public List<Long> selectEntityIdByUserUIId(long userUIId);
	

}