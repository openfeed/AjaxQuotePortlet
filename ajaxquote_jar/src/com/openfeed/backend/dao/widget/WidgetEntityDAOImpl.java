package com.openfeed.backend.dao.widget;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.widget.WidgetEntity;

/**
 * widget Entity DAO Implementation class
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
@Repository("widgetEntityDAO")
public class WidgetEntityDAOImpl extends AbstractWidgetEntityDAO {

	public WidgetEntity select(long id) throws RecordNotFoundException {
		WidgetEntity we = em.find(WidgetEntity.class, new Long(id));
		if (we == null) {
			throw new RecordNotFoundException("No widget Entity Found");
		}
		return we;
	}

	public WidgetEntity insert(long userId, String uiId)
			throws DuplicateRecordException {
		WidgetEntity vo = new WidgetEntity();
		vo.setUserId(userId);
		vo.setUiId(uiId);
		em.persist(vo);
		return vo;
	}

	public WidgetEntity update(long id, long userId, String uiId)
			throws RecordNotFoundException {
		WidgetEntity vo = this.select(id);
		vo.setUserId(userId);
		vo.setUiId(uiId);
		em.merge(vo);
		return vo;
	}

	public void delete(long id) {
		try {
			WidgetEntity we = this.select(id);
			em.remove(we);
		} catch (RecordNotFoundException e) {
			// ok to skip
		}
	}

	@Override
	public WidgetEntity select(long userId, String uiId)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select we from WidgetEntity we where we.userId=:uid and we.uiId=:uiid");
		q.setParameter("uid", new Long(userId));
		q.setParameter("uiid", uiId);
		WidgetEntity we = null;
		try {
			we = (WidgetEntity) q.getSingleResult();
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No WidgetEntity Found");
		}
		return we;
	}

}