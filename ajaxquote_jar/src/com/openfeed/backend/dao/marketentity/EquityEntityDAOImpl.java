package com.openfeed.backend.dao.marketentity;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.equity.EquityEntity;

@Repository("equityEntityDAO")
public class EquityEntityDAOImpl extends AbstractEquityEntityDAO {

	public EquityEntity select(String symbol, String exchange)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select c from EquityEntity c where c.symbol=:symbol and c.exchange=:exchange");
		q.setParameter("symbol", symbol);
		q.setParameter("exchange", exchange);
		try {
			EquityEntity c = (EquityEntity) q.getSingleResult();
			return c;
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No EquityEntity Found");
		}
	}


	@Override
	public List<EquityEntity> searchEntity(String searchStr) {
		Query q = em
				.createQuery("select c from EquityEntity c where c.symbol like :symbol or c.companyName like :companyName or c.industry like :ind");
		q.setParameter("symbol", "%" + searchStr + "%");
		q.setParameter("companyName", "%" + searchStr + "%");
		q.setParameter("ind", "%" + searchStr + "%");
		List<EquityEntity> list = q.getResultList();
		return list;
	}

	@Override
	public void insert(String symbol, String exchange, String companyName,
			String industry) {
		EquityEntity ee = new EquityEntity();
		ee.setSymbol(symbol);
		ee.setCompanyName(companyName);
		ee.setExchange(exchange);
		ee.setIndustry(industry);
		em.persist(ee);
	}

}