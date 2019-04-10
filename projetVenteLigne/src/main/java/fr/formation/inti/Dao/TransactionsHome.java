package fr.formation.inti.Dao;
// Generated 10 avr. 2019 09:22:23 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Transactions;

/**
 * Home object for domain model class Transactions.
 * @see fr.formation.inti.entities.Transactions
 * @author Hibernate Tools
 */
@Stateless
public class TransactionsHome {

	private static final Log log = LogFactory.getLog(TransactionsHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Transactions transientInstance) {
		log.debug("persisting Transactions instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Transactions persistentInstance) {
		log.debug("removing Transactions instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Transactions merge(Transactions detachedInstance) {
		log.debug("merging Transactions instance");
		try {
			Transactions result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Transactions findById(int id) {
		log.debug("getting Transactions instance with id: " + id);
		try {
			Transactions instance = entityManager.find(Transactions.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
