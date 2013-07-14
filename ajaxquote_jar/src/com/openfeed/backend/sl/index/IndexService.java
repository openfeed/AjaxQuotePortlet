package com.openfeed.backend.sl.index;

import java.util.List;

import com.openfeed.backend.vo.index.Index;

public interface IndexService {

	public List<Index> searchIndex(String searchStr);
	
}
