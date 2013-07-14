package com.openfeed.backend.vo.currency;

//import 

/**
 * currency Market
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Sun Mar 20 11:54:36 EDT 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public class CurrencyMarket {
 
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
	 * description
	 */
	private String description;
	
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
		sb.append("\ndescription: " + description);
		return sb.toString();
	}
	
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getExchange() {
		return exchange;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String getLabel() {
		return new StringBuffer(symbol).append(space_dash).append(description).toString();
	}

	public String getValue() {
		return symbol;
	}
}