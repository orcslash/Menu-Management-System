package eu.mintautas.menu.service.api;

import java.util.List;

import eu.mintautas.menu.entities.Item;
/**
 * @author mkiulkys
 * @version 1.0
 */
public interface ItemService {
	/**
	 * Creates {@link Item} object and saves it database.
	 * @param item object with properties.
	 * @return Id of a created item.
	 */
	Integer createItem(Item item);

	/**
	 * Retrieves existing item object by given id.
	 * @param id of an item to return.
	 * @return {@link Item} object by given id.
	 */
	Item retrieveItem(Integer id);

	/**
	 * Updates existing item with new values.
	 * @param item object with new values..
	 */
	void updateItem(Item item);

	/**
	 * Delete item by given id.
	 * @param id of item to delete.
	 */
	void deleteItem(Integer id);

	/**
	 * Returns all items from database.
	 * @return List<{@link Item}> object.
	 */
	List<Item> retrieveAllItems();
}