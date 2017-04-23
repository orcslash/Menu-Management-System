package eu.mintautas.menu.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.mintautas.menu.dao.api.MenuDAO;
import eu.mintautas.menu.entities.Menu;
/**
 * @author mkiulkys
 * @version 1.0
 */
@Transactional
@Repository(value = "menuDAO")
@SuppressWarnings("unchecked")
public class MenuDAOImpl implements MenuDAO {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * {@inheritDoc}
	 */
	public Integer create(Menu menu) {
		if (menu.getId() == null) {
			getEntityManager().persist(menu);
		} else {
			getEntityManager().merge(menu);
		}
		return menu.getId();
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu retrieve(Integer id) {
		Menu menu = getEntityManager().find(Menu.class, id);
		return menu;
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(Menu menu) {
		getEntityManager().merge(menu);
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(Integer id) {
		Menu menu = getEntityManager().find(Menu.class, id);
		getEntityManager().remove(menu);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Menu> retrieveAllMenus() {
		List<Menu> menuList = getEntityManager().createQuery
				("SELECT m FROM Menu m").getResultList();
		return menuList;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}
}