package br.com.gov.dma.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.gov.dma.entity.PerfilEntity;

public class PerfilRepository extends RepositoryFactory {

	@PersistenceContext(unitName = "crudDma-jpa")
	private EntityManager entityManager;

	public void criarNovoPefil(PerfilEntity novoPerfil) throws Exception {

		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(novoPerfil);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public List<PerfilEntity> listarPerfilFiltro(Long id, String tipol) {
		final Criteria criteria = getSessionHibernate().createCriteria(PerfilEntity.class);
		return criteria.list();
	}

//			Buscando por id
	public PerfilEntity buscarPerfil(Long id) {
		final Criteria criteria = getSessionHibernate().createCriteria(PerfilEntity.class);
		criteria.add(Restrictions.eq("id", id));
		criteria.setMaxResults(1);
		return (PerfilEntity) criteria.uniqueResult();
	}

//			******************************************************* VER ***************
	public void atualizaPeffil(PerfilEntity perfil) throws Exception {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();

		try {
			em.remove(em);//// ********************************************** MUYDAR PARA UPTADE
			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();

		}
	}

	public void removePerfil(PerfilEntity perfil) throws Exception {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(em);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

}
