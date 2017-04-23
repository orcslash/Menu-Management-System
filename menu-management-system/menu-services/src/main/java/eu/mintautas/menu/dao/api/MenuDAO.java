package eu.mintautas.menu.dao.api;

import java.util.List;

import eu.mintautas.menu.dao.api.BaseDAO;
import eu.mintautas.menu.entities.Menu;
/**
 * {@link MenuDAO} interface.
 * @author mkiulkys
 * @version 1.0
 */
public interface MenuDAO extends BaseDAO<Menu> {
	/**
	 * Returns all {@link Menu} objects from database.
	 * @return List<{@link Menu}> object.
	 */
	List<Menu> retrieveAllMenus();
}