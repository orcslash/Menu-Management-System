package eu.mintautas.menu.dao.api;

import java.util.List;

import eu.mintautas.menu.entities.Item;
/**
 * {@link ItemDAO} interface.
 * @author mkiulkys
 * @version 1.0
 */
public interface ItemDAO extends BaseDAO<Item> {
	/**
	 * Returns all {@link Item} objects from database.
	 * @return List<{@link Item}> object.
	 */
	List<Item> retrieveAllItems();
}