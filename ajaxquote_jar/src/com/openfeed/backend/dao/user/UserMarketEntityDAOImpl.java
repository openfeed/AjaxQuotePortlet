package com.openfeed.backend.dao.user;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.UserMarketEntity;

/**
 * user DAO Implementation class
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
@Repository("userMarketEntityDAO")
public class UserMarketEntityDAOImpl extends AbstractUserMarketEntityDAO {

	public UserMarketEntity select(long userId, long entityId)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select ume from UserMarketEntity ume where ume.userId=:uid and ume.entityId=:eid");
		q.setParameter("uid", new Long(userId));
		q.setParameter("eid", new Long(entityId));
		try {
			UserMarketEntity ume = (UserMarketEntity) q.getSingleResult();
			return ume;
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No UserMarketEntity Found");
		}

	}

	public UserMarketEntity insert(long userId, long entityId)
			throws DuplicateRecordException {
		UserMarketEntity vo = new UserMarketEntity();
		vo.setUserId(userId);
		vo.setEntityId(entityId);
		em.persist(vo);
		return vo;
	}

	public void delete(long userId, long entityId) {
		try {
			UserMarketEntity vo = this.select(userId, entityId);
			em.remove(vo);
		} catch (RecordNotFoundException e) {
			// we are removing so we don't care
		}

	}

	@Override
	public List<UserMarketEntity> selectByEntityId(long entityId) {
		Query q = em
				.createQuery("select ume from UserMarketEntity ume where ume.entityId=:eid");
		q.setParameter("eid", new Long(entityId));
		List<UserMarketEntity> list = q.getResultList();
		return list;
	}

	@Override
	public List<UserMarketEntity> selectByUserId(long userId) {
		Query q = em
				.createQuery("select ume from UserMarketEntity ume where ume.userId=:uid");
		q.setParameter("uid", new Long(userId));
		List<UserMarketEntity> list = q.getResultList();
		return list;
	}

	@Override
	public List<Long> selectEntityIdByWidgetUserId(long uiId) {
		Query q = em
				.createQuery("select ume.entityId from UserMarketEntity ume where ume.userId=:uid");
		q.setParameter("uid", new Long(uiId));
		List<Long> list = q.getResultList();
		return list;
	}
}