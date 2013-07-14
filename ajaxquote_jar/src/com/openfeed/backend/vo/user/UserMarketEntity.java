package com.openfeed.backend.vo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import 

/**
 * user
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Wed Mar 23 19:55:28 EDT 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
@Entity
@Table(name="wdgt_user_market_entity")
public class UserMarketEntity {
 
	private long id;
	
	/**
	 * userId
	 */
	private long userId;
	
	
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
		sb.append("\nuserId: " + userId);
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

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name="user_id")
	public long getUserId() {
		return userId;
	}

	@Column(name="entity_id")
	public long getEntityId() {
		return entityId;
	}

	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}

	
}