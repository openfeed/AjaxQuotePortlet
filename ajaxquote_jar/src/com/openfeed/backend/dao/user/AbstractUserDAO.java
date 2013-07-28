package com.openfeed.backend.dao.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

/**
 * user DAO Abstract class
 * 
 * @version 1.0
 * @author DB2Java
 * 
 *         <p>
 *         <b>Modification History</b><br>
 *         Date: Wed Mar 23 19:55:28 EDT 2011<br>
 *         Author: DB2Java<br>
 *         Comments: Original<br>
 */
public abstract class AbstractUserDAO implements UserDAO {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(AbstractUserDAO.class);

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}