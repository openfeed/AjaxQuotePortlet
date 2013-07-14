package com.openfeed.backend.dao.next;



import java.util.List;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;


public interface NextNumberDAO {
	/**
	 * Select Method
	 * @see com.unifirst.backoffice.common.dao.CPNextNumberDAO#getCatalogsCategoryLocale(long, java.lang.String)
	 */
	public NextNumber select(String code) throws RecordNotFoundException;

	/**
	 * Insert Method
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#addCatalogsCategory(long, long, boolean, java.lang.String)
	 */
	public NextNumber insert(String code, long number, String description)
		throws DuplicateRecordException ;

	/**
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#update(long, long, java.lang.String, boolean, boolean, String, String, String, int, String, String)
	 */
	public NextNumber update(String code, long number, String description)
		throws RecordNotFoundException;

	/**
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#getFuzzyCodeList(java.lang.String)
	 */
	public List getFuzzyCodeList(String search);
	
	/**
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#getNext(java.lang.String)
	 */
	public long getNext(String code) throws RecordNotFoundException;
}
