package com.openfeed.backend.vo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="wdgt_user")
public class User {
 
	/**
	 * userId
	 */
	private long userId;
	
	
	/**
	 * userName
	 */
	private String userName;
	
	

	
	/**
	 * toString method for logging purposes 
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\nuserId: " + userId);
		sb.append("\nuserName: " + userName);
		return sb.toString();
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	public long getUserId() {
		return userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="user_name")	
	public String getUserName() {
		return userName;
	}

}