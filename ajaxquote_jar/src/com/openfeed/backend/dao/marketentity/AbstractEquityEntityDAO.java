package com.openfeed.backend.dao.marketentity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

public abstract class AbstractEquityEntityDAO implements EquityEntityDAO {

	/**
	 * Logger
	 */
	static Logger log = Logger.getLogger(AbstractEquityEntityDAO.class);

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

}