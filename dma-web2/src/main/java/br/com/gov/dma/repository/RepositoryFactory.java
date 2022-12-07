package br.com.gov.dma.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.ejb.EntityManagerImpl;

public class RepositoryFactory {

	private static EntityManagerFactory FACTORY;

	public EntityManager getEntityManager(){
		
		EntityManager entityManager = null;
		
		try {
			
			if(FACTORY == null) {

				FACTORY = Persistence.createEntityManagerFactory("crudDma-jpa");	
	
				if(FACTORY == null) {
					throw new RuntimeException("Erro ao inicializar o EntityManagerFactory da PersistenceUnit !");
				}
			} 
			
			entityManager = FACTORY.createEntityManager();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return entityManager;
	}
	
	protected Session getSessionHibernate() {
		
		Session session;  
		EntityManager manager = getEntityManager();
		
		if (manager.getDelegate() instanceof EntityManagerImpl) {  
		    EntityManagerImpl entityManagerImpl = (EntityManagerImpl) manager.getDelegate();  
		    session = entityManagerImpl.getSession();  
		} else {  
		    session = (Session) manager.getDelegate();  
		}  
		
		return session;
	}
}
