package com.openfeed.backend.dao.marketentity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * companies DAO Abstract class
 * 
 * @version 1.0
 * @author DB2Java
 * 
 *         <p>
 *         <b>Modification History</b><br>
 *         Date: Sat Feb 19 19:17:34 EST 2011<br>
 *         Author: DB2Java<br>
 *         Comments: Original<br>
 */
public abstract class AbstractCompaniesDAO implements CompaniesDAO {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(AbstractCompaniesDAO.class);

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}