package com.openfeed.backend.sl.user;

import java.util.List;


import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.User;
import com.openfeed.backend.vo.user.UserMarketEntity;

public interface UserService {

	public User getUserByName(String username) throws RecordNotFoundException;
	
	public User getUserById(long userId) throws RecordNotFoundException;
	
	public User addUser(String username);
	
	public UserMarketEntity addUserMarketEntity(long userId, long entityId) throws DuplicateRecordException;
	
	public List<UserMarketEntity> listUserMarketEntityByUser(long userId);
	
	public UserMarketEntity addUserMarketEntity(long userId, String type, String symbol, String exchange,
			String companyName) throws DuplicateRecordException;
	
	public void removeUserMarketEntity(long userId, long entityId);
	
}
