package com.openfeed.backend.dao.marketentity;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.stocks.MarketEntity;

/**
 * DAO Implementation class
 * 
 * @version 1.0
 * @author DB2Java
 * 
 *         <p>
 *         <b>Modification History</b><br>
 *         Date: Tue Feb 22 19:03:28 EST 2011<br>
 *         Author: DB2Java<br>
 *         Comments: Original<br>
 */
@Repository("marketEntityDAO")
public class MarketEntityDAOImpl extends AbstractMarketEntityDAO {

	public MarketEntity select(long entityId) throws RecordNotFoundException {
		MarketEntity me = em.find(MarketEntity.class, new Long(entityId));
		if (me == null) {
			throw new RecordNotFoundException("No Market Entity Found");
		}
		return me;
	}

	@Override
	public MarketEntity selectBySymbol(String symbol)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select me from MarketEntity me where me.symbol=:symbol");
		q.setParameter("symbol", symbol);
		try {
			MarketEntity me = (MarketEntity) q.getSingleResult();
			return me;
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No MarketEntity Found");
		}
	}

	public MarketEntity insert(String type, String symbol, String exchange,
			String companyName) throws DuplicateRecordException {
		MarketEntity vo = new MarketEntity();
		vo.setType(type);
		vo.setSymbol(symbol);
		vo.setExchange(exchange);
		vo.setCompanyName(companyName);
		em.persist(vo);
		return vo;
	}

	public MarketEntity update(long entityId, String type, String symbol,
			String exchange, String companyName) throws RecordNotFoundException {
		MarketEntity vo = this.select(entityId);
		vo.setType(type);
		vo.setSymbol(symbol);
		vo.setExchange(exchange);
		vo.setCompanyName(companyName);
		em.merge(vo);
		return vo;
	}

	public void delete(long entityId) {
		try {
			MarketEntity me = this.select(entityId);
			em.remove(me);
		} catch (RecordNotFoundException e) {
			// ok to skip
		}
	}

	@Override
	public List<MarketEntity> list() {
		List<MarketEntity> list = em.createQuery("select me from MarketEntity")
				.getResultList();
		return list;
	}

	@Override
	public List<MarketEntity> listByTypeUserId(String type, List<Long> entityIds) {
		Query q = em
				.createQuery("select me from MarketEntity me where me.entityId IN (:entityIds) and me.type=:type");
		if (entityIds.isEmpty()) {
			entityIds.add(0l);
		}
		q.setParameter("entityIds", entityIds);
		q.setParameter("type", type);
		List<MarketEntity> list = q.getResultList();
		return list;
	}

	@Override
	public List<MarketEntity> listByUserId(long userId) {
		Query q = em
				.createQuery("select me from MarketEntity me where me.userId=:uid");
		q.setParameter("uid", userId);
		List<MarketEntity> list = q.getResultList();
		return list;
	}

}