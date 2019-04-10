package fr.formation.inti.Dao;
// Generated 10 avr. 2019 09:22:23 by Hibernate Tools 5.1.10.Final

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import fr.formation.inti.entities.Messages;

/**
 * Home object for domain model class Messages.
 * @see fr.formation.inti.entities.Messages
 * @author Hibernate Tools
 */
@Stateless
public class MessagesHome {

	private static final Log log = LogFactory.getLog(MessagesHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Messages transientInstance) {
		log.debug("persisting Messages instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Messages persistentInstance) {
		log.debug("removing Messages instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Messages merge(Messages detachedInstance) {
		log.debug("merging Messages instance");
		try {
			Messages result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Messages findById(int id) {
		log.debug("getting Messages instance with id: " + id);
		try {
			Messages instance = entityManager.find(Messages.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
