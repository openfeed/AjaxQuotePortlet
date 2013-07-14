package com.openfeed.backend.dao.marketentity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.openfeed.backend.dao.next.NextNumberDAO;


/**
 * DAO Abstract class
 * 
 * @version 	1.0
 * @author		DB2Java
 * 
 *  <p><b>Modification History</b><br>
 *  Date: Tue Feb 22 19:03:28 EST 2011<br>
 *  Author: DB2Java<br>
 *  Comments: Original<br>
 */
public abstract class AbstractMarketEntityDAO implements MarketEntityDAO{

	/**
	 * Logger 
	 */
	static Logger log =
		Logger.getLogger(AbstractMarketEntityDAO.class);

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}