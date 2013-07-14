package com.openfeed.backend.dao.currency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.RowMapper;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.currency.CurrencyMarket;

/**
 * currency Market DAO Implementation class
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Sun Mar 20 11:54:36 EDT 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public class CurrencyMarketDAOImpl extends AbstractCurrencyMarketDAO {

	public CurrencyMarket select(String symbol) throws RecordNotFoundException {
		final Object[] params =
			new Object[] { symbol };
		List list =
			jdbcTemplate.query(
				selectSQL,
				params,
					new CurrencyMarketRowMapper());
		if (list.isEmpty()) {
			throw new RecordNotFoundException("No currency Market Found");
		}
		return (CurrencyMarket) list.get(0);
	}

	public CurrencyMarket insert(String symbol, String exchange, String description) throws DuplicateRecordException {
		CurrencyMarket vo = new CurrencyMarket();
		
		vo.setSymbol(symbol);
		vo.setExchange(exchange);
		vo.setDescription(description);

		// set insert parameters 
		Object[] params =
			new Object[] {symbol, exchange, description};
		// set insert parameter types 
		int[] args =
			new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR };
		// execute insert
		try {
			jdbcTemplate.update(insertSQL, params, args);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateRecordException(e, "Duplicate Record Entry");
		}
		return vo;
	}

	public CurrencyMarket update(String symbol, String exchange, String description) throws RecordNotFoundException {
		CurrencyMarket vo = select(symbol);
		vo.setSymbol(symbol);
		vo.setExchange(exchange);
		vo.setDescription(description);

		// set update parameters 
		Object[] params =
			new Object[] {exchange, description, symbol};
		// set update parameter types 
		int[] args =
			new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		// execute update
		try {
			jdbcTemplate.update(updateSQL, params, args);
		} catch (DataIntegrityViolationException e) {
			throw new RecordNotFoundException(e, "Record Not Found Entry");
		}
		return vo;
	}
	
	public void delete(String symbol) {
		// set delete parameters
		Object[] params = new Object[] { symbol };
		// set delete parameter types
		int[] args = new int[] { Types.VARCHAR };
		// execute update
		jdbcTemplate.update(deleteSQL, params, args);
	}

	@Override
	public List<CurrencyMarket> searchCurrency(String searchStr) {
		final Object[] params =
			new Object[] { "%"+searchStr+"%","%"+searchStr+"%" };
		List list =
			jdbcTemplate.query(
				selectCurrencySQL,
				params,
					new CurrencyMarketRowMapper());
		return list;
	}
	
	/**
	 * 
	 * Row mapper object
	 * 
	 * @version 	1.0
	 * @author		DB2Java
	 * 
	 *  <p><b>Modification History</b><br>
	 *  Date: April 8, 2008<br>
	 *  Author: DB2Java<br>
	 *  Comments: Original<br>
	 */
	class CurrencyMarketRowMapper implements RowMapper {

		/**
		 * Private helper method to map a result set row to a Value Object Object 
		 * @param rs
		 * @param index
		 * @return
		 * @throws SQLException
		 */
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			CurrencyMarket vo = new CurrencyMarket();
			vo.setSymbol(rs.getString("Symbol"));
			vo.setExchange(rs.getString("Exchange"));
			vo.setDescription(rs.getString("Description"));

			return vo;
		}
	}

}