package br.com.gov.dma.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.gov.dma.entity.UsuarioEntity;

public class UsuarioRepository extends RepositoryFactory {

	public void criarNovoUsuario(UsuarioEntity novoUsuario)
	throws Exception {
		
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(novoUsuario);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public List<UsuarioEntity> listarUsuariosFiltro(String nome, String cpf, Date dataInicio, Date dataFinal){
		final Criteria criteria = getSessionHibernate().createCriteria(UsuarioEntity.class);
		return criteria.list();
	}
//	Buscando por CPF
	public UsuarioEntity buscarUsuario(String cpfBusca) {
		final Criteria criteria = getSessionHibernate().createCriteria(UsuarioEntity.class);
		criteria.add(Restrictions.eq("cpf", cpfBusca));
		criteria.setMaxResults(1);
		return (UsuarioEntity) criteria.uniqueResult();
	}
	
	
	public UsuarioEntity buscarUsuario(UsuarioEntity usuario) {
		final Criteria criteria = getSessionHibernate().createCriteria(UsuarioEntity.class);
//		criteria.add(Restrictions.eq("cpf", cpfBusca));
		criteria.setMaxResults(1);
		return (UsuarioEntity) criteria.uniqueResult();
	}
	
//	******************************************************* VER ***************
	public void atualizaUsuario(UsuarioEntity usuario) throws Exception{
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
	
	
	
	public void removeUsuario(UsuarioEntity usuario) throws Exception {
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
