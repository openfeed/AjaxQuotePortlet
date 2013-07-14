package com.openfeed.backend.dao.next;



import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractNextNumberDAO implements NextNumberDAO {
	String selectSQL;

	String insertSQL;

	String updateSQL;

	String listSQL;

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setInsertSQL(String insertSQL) {
		this.insertSQL = insertSQL;
	}

	public void setSelectSQL(String selectSQL) {
		this.selectSQL = selectSQL;
	}

	public void setUpdateSQL(String updateSQL) {
		this.updateSQL = updateSQL;
	}

	public void setListSQL(String listSQL) {
		this.listSQL = listSQL;
	}
}
