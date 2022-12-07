package br.com.gov.dma.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.gov.dma.entity.EnderecoEntity;




public class EnderecoRepository extends RepositoryFactory {

	@PersistenceContext(unitName="crudDma-jpa")
	private EntityManager entityManager;
	
	public void criarNovoEndereco(EnderecoEntity novoEndereco)
			throws Exception {
				
				EntityManager em = getEntityManager();
				em.getTransaction().begin();
				try {
					em.persist(novoEndereco);
					em.getTransaction().commit();
				} catch (Exception e) {
					em.getTransaction().rollback();
					throw e;
				} finally {
					em.close();
				}
			}

			public List<EnderecoEntity> listarEndereco(String cep, String logradouro){
				final Criteria criteria = getSessionHibernate().createCriteria(EnderecoEntity.class);
				return criteria.list();
			}
			
			
//			Buscando por id
			public EnderecoEntity buscarEndereco(String cep) {
				final Criteria criteria = getSessionHibernate().createCriteria(EnderecoEntity.class);
				criteria.add(Restrictions.eq("cep", cep));
				criteria.setMaxResults(1);
				return (EnderecoEntity) criteria.uniqueResult();
			}
			
			
			
			
//			******************************************************* VER ***************
			public void atualizaEndereco(EnderecoEntity endereco) throws Exception{
				EntityManager em = getEntityManager();
				em.getTransaction().begin();
				
				try {
					em.remove(em);////********************************************** MUYDAR PARA UPTADE
					em.getTransaction().commit();
					
				}catch(Exception e) {
					em.getTransaction().rollback();
					}finally {
						em.close();
				
				}
			}
			
			
			
			public void removeEndereco(EnderecoEntity endereco) throws Exception {
				EntityManager em = getEntityManager();
				em.getTransaction().begin();
				try {
					em.remove(em);
					em.getTransaction().commit();
				}catch(Exception e) {
					em.getTransaction().rollback();
				}finally {
					em.close();
				}
			}
		
	
	
}
