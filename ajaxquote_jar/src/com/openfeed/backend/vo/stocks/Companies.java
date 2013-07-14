package com.openfeed.backend.vo.stocks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


//import 

/**
 * companies
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Sat Feb 19 19:17:34 EST 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
@Entity
@Table(name="equity_entity")
public class Companies {
 
	private static final String space_dash = " - ";
	
	/**
	 * symbol
	 */
	private String symbol;
	
	
	/**
	 * exchange
	 */
	private String exchange;
	
	
	/**
	 * companyName
	 */
	private String companyName;
	
	/**
	 * industry
	 */
	private String industry;
	
	/**
	 * Field is needed for ajax autocomplete
	 */
	private String label;
	
	private String value;
	
	/**
	 * toString method for logging purposes 
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\nsymbol: " + symbol);
		sb.append("\nexchange: " + exchange);
		sb.append("\ncompanyName: " + companyName);
		return sb.toString();
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Id 
	public String getSymbol() {
		return symbol;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getExchange() {
		return exchange;
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

	@Transient
	public String getLabel() {
		return new StringBuffer(symbol).append(space_dash).append(companyName).append(space_dash).append(industry).toString();
	}

	@Transient
	public String getValue() {
		return symbol;
	}
	
}