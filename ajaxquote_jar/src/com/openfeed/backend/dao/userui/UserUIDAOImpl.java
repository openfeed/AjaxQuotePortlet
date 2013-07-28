package com.openfeed.backend.dao.userui;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.userui.UserUI;

@Repository("userUIDAO")
public class UserUIDAOImpl extends AbstractUserUIDAO {

	public UserUI select(long userUIId) throws RecordNotFoundException {
		UserUI we = em.find(UserUI.class, new Long(userUIId));
		if (we == null) {
			throw new RecordNotFoundException("No UserUI Found");
		}
		return we;
	}

	public UserUI insert(long userId, String uiId)
			throws DuplicateRecordException {
		UserUI vo = new UserUI();
		vo.setUserId(userId);
		vo.setUiId(uiId);
		em.persist(vo);
		return vo;
	}

	public UserUI update(long userUIId, long userId, String uiId)
			throws RecordNotFoundException {
		UserUI vo = this.select(userUIId);
		vo.setUserId(userId);
		vo.setUiId(uiId);
		em.merge(vo);
		return vo;
	}

	public void delete(long userUIId) {
		try {
			UserUI we = this.select(userUIId);
			em.remove(we);
		} catch (RecordNotFoundException e) {
			// ok to skip
		}
	}

	@Override
	public UserUI select(long userId, String uiId)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select we from UserUI we where we.userId=:uid and we.uiId=:uiid");
		q.setParameter("uid", new Long(userId));
		q.setParameter("uiid", uiId);
		UserUI we = null;
		try {
			we = (UserUI) q.getSingleResult();
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No UserUI Found");
		}
		return we;
	}

}