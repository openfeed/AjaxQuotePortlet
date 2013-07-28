package com.openfeed.backend.vo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wdgt_user_ui_market_entity")
public class UserUIMarketEntity {
 
	private long id;
	
	/**
	 * userId
	 */
	private long userUIId;
	
	
	/**
	 * userName
	 */
	private long entityId;
	
	
	/**
	 * toString method for logging purposes 
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\nId: " + id);
		sb.append("\nuserUIId: " + userUIId);
		sb.append("\nentityId: " + entityId);
		return sb.toString();
	}
	
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setUserUIId(long userUIId) {
		this.userUIId = userUIId;
	}

	@Column(name="user_ui_id")
	public long getUserUIId() {
		return userUIId;
	}

	@Column(name="entity_id")
	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	
}