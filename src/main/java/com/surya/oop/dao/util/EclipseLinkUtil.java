package com.surya.oop.dao.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EclipseLinkUtil {
	private static final String PERSISTENCE_UNIT_NAME = "OutOfPocket";
	private static EntityManagerFactory factory;
	
	static {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	  
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static void commitAndCloseEntityManager(EntityManager em) {
		if(em.isOpen()) {
			if(em.isJoinedToTransaction()) {
				if(em.getTransaction() != null) {
					em.getTransaction().commit();	
				}
			}
			
			em.close();	
		}
	}
	
	public static void rollbackAndCloseEntityManager(EntityManager em) {
		if(em.isOpen()) {
			if(em.isJoinedToTransaction()) {
				if(em.getTransaction() != null) {
					em.getTransaction().rollback();
				}
			}
			
			em.close();	
		}
	}
}
