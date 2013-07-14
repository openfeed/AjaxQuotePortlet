package com.openfeed.backend.vo.stocks;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import 

/**
 * widget Entity
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Thu Jun 06 20:48:53 EDT 2013<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
@Entity
@Table(name="equity_entity")
public class EquityEntity {
 
	/**
	 * symbol
	 */
	private String symbol;
	
	
	/**
	 * exchange
	 */
	private String exchange;
	
	
	/**
	 * company name
	 */
	private String companyName;
	
	/**
	 * industry
	 */
	private String industry;

	@Id 
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}
	
}