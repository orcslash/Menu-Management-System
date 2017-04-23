package eu.mintautas.menu.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import eu.mintautas.menu.dao.impl.ItemDAOImpl;
import eu.mintautas.menu.entities.Item;
import eu.mintautas.menu.service.api.ItemService;
/**
 * @author mkiulkys
 * @version 1.0
 */
@Service(value = "itemService")
@Scope("prototype")
public class ItemServiceImpl implements ItemService {

	private static Logger logger = Logger.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemDAOImpl itemDAOImpl;

	/**
	 * {@inheritDoc}
	 */
	public Integer createItem(Item item) {
		Integer id = getItemDAOImpl().create(item);
		logger.info("Item added to databese. Id: " + id);
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public Item retrieveItem(Integer id) {
		Item item = getItemDAOImpl().retrieve(id);
		return item;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateItem(Item item) {
		getItemDAOImpl().update(item);
		logger.info("Item was successfully updated. Id: " + item.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteItem(Integer id) {
		getItemDAOImpl().delete(id);
		logger.info("Item was successfully deleted. Id: " + id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Item> retrieveAllItems() {
		List<Item> itemList = getItemDAOImpl().retrieveAllItems();
		if (itemList.isEmpty()) {
			logger.info("No data was found.");
		}
		return itemList;
	}

	public ItemDAOImpl getItemDAOImpl() {
		return itemDAOImpl;
	}

	public void setItemDAOImpl(ItemDAOImpl itemDAOImpl) {
		this.itemDAOImpl = itemDAOImpl;
	}
}