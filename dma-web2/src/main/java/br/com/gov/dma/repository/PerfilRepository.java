package br.com.gov.dma.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PerfilRepository {

	@PersistenceContext(unitName="crudDma-jpa")
	private EntityManager entityManager;
	
	
	
}
