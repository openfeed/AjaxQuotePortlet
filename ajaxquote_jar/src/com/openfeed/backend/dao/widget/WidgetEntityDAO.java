package com.openfeed.backend.dao.widget;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.widget.WidgetEntity;

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
public interface WidgetEntityDAO {

	/**
	 * Select Method
	 */
	public WidgetEntity select(long id) throws RecordNotFoundException;
	
	public WidgetEntity select(long userId, String uiId) throws RecordNotFoundException;
	
	/**
	 * Insert Method
	 */
	public WidgetEntity insert(long userId, String uiId) throws DuplicateRecordException;
	
	/**
	 * Update Method
	 */
	public WidgetEntity update(long id, long userId, String uiId) throws RecordNotFoundException;
	
	/**
	 * Delete Method
	 */
	public void delete(long id);
	
}