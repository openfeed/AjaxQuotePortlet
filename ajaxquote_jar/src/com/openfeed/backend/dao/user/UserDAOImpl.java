package com.openfeed.backend.dao.user;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.User;

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
@Repository("userDAO")
public class UserDAOImpl extends AbstractUserDAO {

	public User select(long userId) throws RecordNotFoundException {
		User user = em.find(User.class, new Long(userId));
		if (user == null) {
			throw new RecordNotFoundException("No user Found");
		}
		return user;
	}

	@Override
	public User selectByName(String username) throws RecordNotFoundException {
		Query q = em.createQuery("select u from User u where u.userName=:name");
		q.setParameter("name", username);
		try {
			User user = (User) q.getSingleResult();
			return user;
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No User Found");
		}
	}

	public User insert(String userName) throws DuplicateRecordException {
		User u = new User();
		u.setUserName(userName);
		em.persist(u);
		return u;
	}

	public User update(long userId, String userName)
			throws RecordNotFoundException {
		User vo = this.select(userId);
		vo.setUserName(userName);
		em.merge(vo);
		return vo;
	}

	public void delete(long userId) {
		try {
			User u = this.select(userId);
			em.remove(u);
		} catch (RecordNotFoundException e) {
			// ok to skip
		}

	}

}