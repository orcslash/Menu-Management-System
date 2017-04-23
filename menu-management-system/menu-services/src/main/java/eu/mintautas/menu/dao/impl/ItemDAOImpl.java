package eu.mintautas.menu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.mintautas.menu.dao.api.ItemDAO;
import eu.mintautas.menu.entities.Item;
/**
 * @author mkiulkys
 * @version 1.0
 */
@Transactional
@Repository(value = "itemDAO")
public class ItemDAOImpl implements ItemDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	public Integer create(Item item) {
		if (item.getId() == null) {
			getEntityManager().persist(item);
		} else {
			getEntityManager().merge(item);
		}
		return item.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	public Item retrieve(Integer id) {
		Item item = getEntityManager().find(Item.class, id);
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(Item item) {
		getEntityManager().merge(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(Integer id) {
		Item item = getEntityManager().find(Item.class, id);
		getEntityManager().remove(item);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> retrieveAllItems() {
		@SuppressWarnings("unchecked")
		List<Item> itemList = getEntityManager().createQuery
			("SELECT i FROM Item i").getResultList();
		return itemList;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}