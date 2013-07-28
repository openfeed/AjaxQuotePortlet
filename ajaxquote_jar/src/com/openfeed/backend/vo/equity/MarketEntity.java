package com.openfeed.backend.vo.equity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="wdgt_market_entity")
public class MarketEntity {
 
	/**
	 * entityId
	 */
	private long entityId;
	
	/**
	 * Type
	 */
	private String type;
	
	
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
	 * companyName
	 */
	private String industry;
	
	
	/**
	 * toString method for logging purposes 
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\nstockId: " + entityId);
		sb.append("\ntype: " + type);
		sb.append("\nsymbol: " + symbol);
		sb.append("\nexchange: " + exchange);
		sb.append("\ncompanyName: " + companyName);
		return sb.toString();
	}
	
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="entity_id")
	public long getEntityId() {
		return entityId;
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
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Transient
	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}


}