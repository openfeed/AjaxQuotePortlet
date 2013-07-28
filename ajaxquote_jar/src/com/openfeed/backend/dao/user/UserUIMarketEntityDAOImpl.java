package com.openfeed.backend.dao.user;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.UserUIMarketEntity;

@Repository("userUIMarketEntityDAO")
public class UserUIMarketEntityDAOImpl extends AbstractUserUIMarketEntityDAO {

	public UserUIMarketEntity select(long userUIId, long entityId)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select ume from UserUIMarketEntity ume where ume.userUIId=:uid and ume.entityId=:eid");
		q.setParameter("uid", new Long(userUIId));
		q.setParameter("eid", new Long(entityId));
		try {
			UserUIMarketEntity ume = (UserUIMarketEntity) q.getSingleResult();
			return ume;
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No UserUIMarketEntity Found");
		}

	}

	public UserUIMarketEntity insert(long userUIId, long entityId)
			throws DuplicateRecordException {
		UserUIMarketEntity vo = new UserUIMarketEntity();
		vo.setUserUIId(userUIId);
		vo.setEntityId(entityId);
		em.persist(vo);
		return vo;
	}

	public void delete(long userUIId, long entityId) {
		try {
			UserUIMarketEntity vo = this.select(userUIId, entityId);
			em.remove(vo);
		} catch (RecordNotFoundException e) {
			// we are removing so we don't care
		}

	}

	@Override
	public List<UserUIMarketEntity> selectByEntityId(long entityId) {
		Query q = em
				.createQuery("select ume from UserUIMarketEntity ume where ume.entityId=:eid");
		q.setParameter("eid", new Long(entityId));
		List<UserUIMarketEntity> list = q.getResultList();
		return list;
	}

	@Override
	public List<UserUIMarketEntity> selectByUserUIId(long userUIId) {
		Query q = em
				.createQuery("select ume from UserUIMarketEntity ume where ume.userUIId=:uid");
		q.setParameter("uid", new Long(userUIId));
		List<UserUIMarketEntity> list = q.getResultList();
		return list;
	}

	@Override
	public List<Long> selectEntityIdByUserUIId(long userUIId) {
		Query q = em
				.createQuery("select ume.entityId from UserUIMarketEntity ume where ume.userUIId=:uid");
		q.setParameter("uid", new Long(userUIId));
		List<Long> list = q.getResultList();
		return list;
	}
}