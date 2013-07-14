package com.openfeed.backend.dao.currency;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 * currency Market DAO Abstract class
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Sun Mar 20 11:54:36 EDT 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public abstract class AbstractCurrencyMarketDAO implements CurrencyMarketDAO{

	/**
	 * Logger 
	 */
	static Logger log =
		Logger.getLogger(AbstractCurrencyMarketDAO.class);

	/**
	 * JdbcTemplate Object 
	 */
	JdbcTemplate jdbcTemplate;
	
	/**
	 * Select SQL
	 */
	String selectSQL;
	
	/**
	 * Insert SQL
	 */
	String insertSQL;
	
	/**
	 * Update SQL
	 */
	String updateSQL;
	
	/**
	 * Delete SQL
	 */
	String deleteSQL;
	
	/**
	 * selectCurrencySQL
	 */
	String selectCurrencySQL;
	
	public void setDeleteSQL(String deleteSQL) {
		this.deleteSQL = deleteSQL;
	}

	public void setInsertSQL(String insertSQL) {
		this.insertSQL = insertSQL;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setSelectSQL(String selectSQL) {
		this.selectSQL = selectSQL;
	}

	public void setUpdateSQL(String updateSQL) {
		this.updateSQL = updateSQL;
	}

	public void setSelectCurrencySQL(String selectCurrencySQL) {
		this.selectCurrencySQL = selectCurrencySQL;
	}

	
}