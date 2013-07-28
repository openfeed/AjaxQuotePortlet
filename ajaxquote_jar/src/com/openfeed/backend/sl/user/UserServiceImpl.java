package com.openfeed.backend.sl.user;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.equity.MarketEntity;
import com.openfeed.backend.vo.user.User;
import com.openfeed.backend.vo.user.UserUIMarketEntity;

@Service("userService")
public class UserServiceImpl extends AbstractUserService {

	@Override
	@Transactional
	public User addUser(String username) {
		User user = null;
		try {
			user = userDAO.selectByName(username);
		} catch (RecordNotFoundException e1) {
			try {
				user = userDAO.insert(username);
			} catch (DuplicateRecordException e) {
				//already checked in select
			}
		}
		return user;	
	}

	@Override
	@Transactional
	public UserUIMarketEntity addUserUIMarketEntity(long userUIId, long entityId)
			throws DuplicateRecordException {
		return userUIMarketEntityDAO.insert(userUIId, entityId);
	}

	@Override
	public User getUserById(long userId) throws RecordNotFoundException {
		return userDAO.select(userId);
	}

	@Override
	public User getUserByName(String username) throws RecordNotFoundException {
		return userDAO.selectByName(username);
	}

	@Override
	public List<UserUIMarketEntity> listUserUIMarketEntityByUserUIId(long userUIId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public UserUIMarketEntity addUserUIMarketEntity(long userUIId, String type, String symbol,
			String exchange, String companyName)
			throws DuplicateRecordException {
		MarketEntity marketEntity = null;
		try {
			marketEntity = marketEntityDAO.selectBySymbol(symbol);
		} catch (RecordNotFoundException e) {
			// if record does not exist add MarketEntity
			marketEntity = equityUIService.addMarketEntity(type, symbol, exchange, companyName);
		}
		UserUIMarketEntity userMarketEntity = null;
		try {
			userMarketEntity = userUIMarketEntityDAO.select(userUIId, marketEntity.getEntityId());
		} catch (RecordNotFoundException e) {
			userMarketEntity = userUIMarketEntityDAO.insert(userUIId, marketEntity.getEntityId());
		}
		return userMarketEntity;
	}

	@Override
	@Transactional
	public void removeUserUIMarketEntity(long userUIId, long entityId) {
		userUIMarketEntityDAO.delete(userUIId, entityId);
		List<UserUIMarketEntity> list = userUIMarketEntityDAO.selectByEntityId(entityId);
		if (list.isEmpty()){
			try {
				equityUIService.removeMarketEntity(entityId);
			} catch (RecordNotFoundException e) {
				//it is fine since it is a remove method
			}
		}
	}

}
