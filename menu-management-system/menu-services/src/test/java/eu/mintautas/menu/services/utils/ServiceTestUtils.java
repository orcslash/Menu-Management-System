package eu.mintautas.menu.services.utils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import eu.mintautas.menu.entities.Item;
/**
 * {@link ServiceTestUtils} class contains helper methods to test
 * service layer implementations.
 * @author mkiulkys
 */
public final class ServiceTestUtils {

	private static final String LARGE = "Large";

	private ServiceTestUtils() {};

	/** Helper method to create List<{@link Item}> object. */
	public static List<Item> createListOfItems() {
		// Create List For Items
		List<Item> menuItemList = new ArrayList<Item>();

		// Create Item A
		Item itemA = new Item();
		itemA.setItemName("Canadian Pizza Pie");
		itemA.setPrice(BigDecimal.valueOf(9.99));
		itemA.setType("Classic Pizza Pie");
		itemA.setSize(LARGE);

		// Create Item B
		Item itemB = new Item();
		itemB.setItemName("American Pizza Pie");
		itemB.setPrice(BigDecimal.valueOf(13.99));
		itemB.setType("Modern Pizza Pie");
		itemB.setSize(LARGE);

		// Add Both Items To Menu List
		menuItemList.add(itemA);
		menuItemList.add(itemB);

		return menuItemList;
	}
}