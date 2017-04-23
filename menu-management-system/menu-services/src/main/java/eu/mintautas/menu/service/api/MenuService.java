package eu.mintautas.menu.service.api;

import java.util.List;

import eu.mintautas.menu.entities.Menu;
/**
 * @author mkiulkys
 * @version 1.0
 */
public interface MenuService {
	/**
	 * Creates {@link Menu} object and saves it database.
	 * @param menu object with properties.
	 * @return Id of a created menu.
	 */
	Integer createMenu(Menu menu);

	/**
	 * Retrieves existing menu object by given id.
	 * @param id of a menu to return.
	 * @return {@link Menu} object by given id.
	 */
	Menu retrieveMenu(Integer id);

	/**
	 * Updates existing menu with new values.
	 * @param menu object with new values..
	 */
	void updateMenu(Menu menu);

	/**
	 * Delete menu by given id.
	 * @param id of menu to delete.
	 */
	void deleteMenu(Integer id);

	/**
	 * Returns all menus from database.
	 * @return List<{@link Menu}> object.
	 */
	List<Menu> retrieveAllMenus();
}