package com.openfeed.backend.sl.user;

import java.util.List;


import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.user.User;
import com.openfeed.backend.vo.user.UserUIMarketEntity;

public interface UserService {

	public User getUserByName(String username) throws RecordNotFoundException;
	
	public User getUserById(long userId) throws RecordNotFoundException;
	
	public User addUser(String username);
	
	public UserUIMarketEntity addUserUIMarketEntity(long userUIId, long entityId) throws DuplicateRecordException;
	
	public List<UserUIMarketEntity> listUserUIMarketEntityByUserUIId(long userUIId);
	
	public UserUIMarketEntity addUserUIMarketEntity(long userUIId, String type, String symbol, String exchange,
			String companyName) throws DuplicateRecordException;
	
	public void removeUserUIMarketEntity(long userUIId, long entityId);
	
}
