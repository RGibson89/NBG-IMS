package com.qa.nbg_ims.repositories.sql;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import com.qa.nbg_ims.dabaseconnectors.SQLDatabaseConnector;
import com.qa.nbg_ims.entities.Stock;
import com.qa.nbg_ims.repositories.StockRepository;
import com.qa.nbg_ims.util.ProductStatus;

@Stateless
public class StockRepositorySQL implements StockRepository {
	@Inject private SQLDatabaseConnector sqlDatabaseConnector;
	
	public void persistStock(Stock stock) {
		EntityManager entityManager = sqlDatabaseConnector.openEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(stock);
		entityManager.getTransaction().commit();
		sqlDatabaseConnector.closeEntityManager(entityManager);
	}

	public List<Stock> findByStatus(ProductStatus status) {
		EntityManager entityManager = sqlDatabaseConnector.openEntityManager();
		TypedQuery<Stock> typedQuery = entityManager.createNamedQuery(Stock.FIND_BY_STATUS, Stock.class);
		sqlDatabaseConnector.closeEntityManager(entityManager);
		typedQuery.setParameter("status", status);
		try {
			return typedQuery.getResultList();
		} catch (NoResultException noResultException) {
			return null;
		}
	}

	public Stock findByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Stock> findByLowStock() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateStock(Stock stock) {
		if (!stock.equals(null)) {
			EntityManager entityManager = sqlDatabaseConnector.openEntityManager();
			entityManager.merge(stock);
			sqlDatabaseConnector.closeEntityManager(entityManager);
		}
	}
}