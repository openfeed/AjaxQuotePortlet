package com.openfeed.backend.sl.index;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.openfeed.backend.common.IOpenfeedConstants;
import com.openfeed.backend.vo.index.Index;

public class IndexServiceImpl implements IndexService {

	private static final String REGEX = "^[\\$]?%1$s.*$";
	
	private Map<String, String> indexMap;
	
	@Override
	public List<Index> searchIndex(String searchStr) {
		String regex = String.format(REGEX, searchStr.replaceAll("$", "")).toLowerCase();
		List<Index> list = new ArrayList<Index>();
		for (Iterator<Map.Entry<String, String>> j = indexMap.entrySet().iterator();j.hasNext();){
			Map.Entry<String, String> entry = j.next();
			if (entry.getKey().toLowerCase().matches(regex)||entry.getValue().toLowerCase().matches(regex)){
				list.add(new Index(entry.getKey(),IOpenfeedConstants.MARKET_ENTITY_INDEX_TYPE,entry.getValue()));
			}
		}
		return list;
	}

	public void setIndexMap(Map<String, String> indexMap) {
		this.indexMap = indexMap;
	}
	
}
