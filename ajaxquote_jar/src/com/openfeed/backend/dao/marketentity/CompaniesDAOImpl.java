package com.openfeed.backend.dao.marketentity;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.openfeed.backend.common.exceptions.DuplicateRecordException;
import com.openfeed.backend.common.exceptions.RecordNotFoundException;
import com.openfeed.backend.vo.stocks.Companies;
import com.openfeed.backend.vo.stocks.EquityEntity;

/**
 * companies DAO Implementation class
 * 
 * @version 1.0
 * @author DB2Java
 * 
 *         <p>
 *         <b>Modification History</b><br>
 *         Date: Sat Feb 19 19:17:34 EST 2011<br>
 *         Author: DB2Java<br>
 *         Comments: Original<br>
 */
@Repository("companiesDAO")
public class CompaniesDAOImpl extends AbstractCompaniesDAO {

	public Companies select(String symbol, String exchange)
			throws RecordNotFoundException {
		Query q = em
				.createQuery("select c from Companies c where c.symbol=:symbol and c.exchange=:exchange");
		q.setParameter("symbol", symbol);
		q.setParameter("exchange", exchange);
		try {
			Companies c = (Companies) q.getSingleResult();
			return c;
		} catch (NoResultException e) {
			throw new RecordNotFoundException("No Companies Found");
		}
	}


	@Override
	public List<Companies> searchCompany(String searchStr) {
		Query q = em
				.createQuery("select c from Companies c where c.symbol like :symbol or c.companyName like :companyName or c.industry like :ind");
		q.setParameter("symbol", "%" + searchStr + "%");
		q.setParameter("companyName", "%" + searchStr + "%");
		q.setParameter("ind", "%" + searchStr + "%");
		List<Companies> list = q.getResultList();
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