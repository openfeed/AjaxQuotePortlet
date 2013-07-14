package com.openfeed.backend.vo.widget;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name="widget_entity")
public class WidgetEntity {
 
	/**
	 * id
	 */
	private long id;
	
	
	/**
	 * userId
	 */
	private long userId;
	
	
	/**
	 * uiId
	 */
	private String uiId;
	
	

	
	/**
	 * toString method for logging purposes 
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("\nid: " + id);
		sb.append("\nuserId: " + userId);
		sb.append("\nuiId: " + uiId);
		return sb.toString();
	}
	
	public void setId(long id) {
		this.id = id;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Column(name="user_id")
	public long getUserId() {
		return userId;
	}
	public void setUiId(String uiId) {
		this.uiId = uiId;
	}

	@Column(name="ui_id")
	public String getUiId() {
		return uiId;
	}


	
}