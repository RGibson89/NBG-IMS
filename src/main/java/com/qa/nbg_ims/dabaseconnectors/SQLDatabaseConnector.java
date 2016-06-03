package com.qa.nbg_ims.dabaseconnectors;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

@Singleton
public class SQLDatabaseConnector {
	private EntityManagerFactory entityManagerFactory;
	
	public EntityManager openEntityManager() {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("ngbPU");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			return entityManager;
		} catch (PersistenceException persistenceException) {
			return null;
		}
	}
	
	public void closeEntityManager(EntityManager entityManager) {
		entityManager.close();
		entityManagerFactory.close();
	}
}