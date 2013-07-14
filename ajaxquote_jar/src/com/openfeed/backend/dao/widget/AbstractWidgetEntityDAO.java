package com.openfeed.backend.dao.widget;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import com.openfeed.backend.dao.next.NextNumberDAO;

/**
 * widget Entity DAO Abstract class
 * 
 * @version 1.0
 * @author DB2Java
 * 
 *         <p>
 *         <b>Modification History</b><br>
 *         Date: Thu Jun 06 20:48:53 EDT 2013<br>
 *         Author: DB2Java<br>
 *         Comments: Original<br>
 */
public abstract class AbstractWidgetEntityDAO implements WidgetEntityDAO {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(AbstractWidgetEntityDAO.class);

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}