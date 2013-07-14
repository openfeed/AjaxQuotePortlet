package com.openfeed.backend.dao.next;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.RowMapper;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;

/**
 * 
 * @author yablonsky
 * 
 */
public class NextNumberDAOImpl extends AbstractNextNumberDAO {
	/**
	 * Select Method
	 * 
	 * @see com.unifirst.backoffice.common.dao.CPNextNumberDAO#getCatalogsCategoryLocale(long,
	 *      java.lang.String)
	 */
	public NextNumber select(String code) throws RecordNotFoundException {
		// set update parameters
		Object[] params = new Object[] { code };
		List list = jdbcTemplate.query(selectSQL, params,
				new NextNumberRowMapper());
		// throw exception if no record is found
		if (list.isEmpty()) {
			throw new RecordNotFoundException("No CPNextNumber Found");
		}
		// return first element for key values passed
		return (NextNumber) list.get(0);
	}

	/**
	 * Insert Method
	 * 
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#addCatalogsCategory(long, long,
	 *      boolean, java.lang.String)
	 */
	public NextNumber insert(String code, long number, String description)
			throws DuplicateRecordException {
		NextNumber vo = new NextNumber();
		vo.setCode(code);
		vo.setNumber(number);
		vo.setDescription(description);
		// set insert parameters
		Object[] params = new Object[] { code, new Long(number), description };
		// set insert parameter types
		int[] args = new int[] { Types.VARCHAR, Types.NUMERIC, Types.VARCHAR };
		// execute insert
		try {
			jdbcTemplate.update(insertSQL, params, args);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateRecordException(e, "Duplicate Record");
		}
		// return value object
		return vo;
	}

	/**
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#update(long, long,
	 *      java.lang.String, boolean, boolean, String, String, String, int, String, String)
	 */
	public NextNumber update(String code, long number, String description)
			throws RecordNotFoundException {
		// get and override value object
		NextNumber vo = select(code);
		vo.setNumber(number);
		vo.setDescription(description);
		// set update parameters
		Object[] params = new Object[] { new Long(number), description, code };
		// set update parameter types
		int[] args = new int[] { Types.NUMERIC, Types.VARCHAR, Types.VARCHAR };
		// execute update
		jdbcTemplate.update(updateSQL, params, args);
		// return value object
		return vo;
	}

	/**
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#getFuzzyCodeList(java.lang.String)
	 */
	public List getFuzzyCodeList(String search) {
		final Object[] params = new Object[] { "%" + search + "%" };
		List list = jdbcTemplate.query(listSQL, params,
				new NextNumberRowMapper());
		return list;
	}

	/**
	 * @see com.unifirst.backoffice.common.dao.NextNumberDAO#getNext(java.lang.String)
	 */
	public synchronized long getNext(String code)
			throws RecordNotFoundException {
		NextNumber NextNumberVO = null;
		NextNumberVO = select(code);
		update(code, NextNumberVO.getNumber() + 1, NextNumberVO
				.getDescription());
		return NextNumberVO.getNumber();
	}

	/**
	 * 
	 * @author yablonsky
	 * 
	 */
	class NextNumberRowMapper implements RowMapper {

		/**
		 * Private helper method to map a result set row to a NextNumber object
		 * 
		 * @param rs
		 * @param index
		 * @return
		 * @throws SQLException
		 */
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			NextNumber vo = new NextNumber();
			vo.setCode(rs.getString("Code"));
			vo.setNumber(rs.getLong("Number"));
			vo.setDescription(rs.getString("Description"));
			return vo;
		}
	}
}
