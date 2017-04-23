package com.mintautas.menu.services.impl;

import static eu.mintautas.menu.services.utils.ServiceTestUtils.createListOfItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import eu.mintautas.menu.entities.Item;
import eu.mintautas.menu.entities.Menu;
import eu.mintautas.menu.service.impl.ItemServiceImpl;
import eu.mintautas.menu.service.impl.MenuServiceImpl;
/**
 * Integration tests for {@link ItemServiceImpl} class.
 * @author mkiulkys
 * @since 2017-04-23
 */
@ContextConfiguration(locations = { "classpath*:META-INF/spring/*-config.xml" })
@SuppressWarnings("deprecation")
public class ItemServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private MenuServiceImpl menuServiceImpl;

	@Autowired
	private ItemServiceImpl itemServiceImpl;

	private List<Item> itemList;

	@Test
	public void shouldCreateItemsAndRemoveItFromDB() {
		// Create Menu And Retrieve It
		itemServiceImpl.createItem(createListOfItems().get(0));
		itemList = itemServiceImpl.retrieveAllItems();
		assertThat(itemList.size(), is(1));

		// Delete Menu And Assert If It Was Removed
		itemServiceImpl.deleteItem((itemList.get(0).getId()));
		itemList = itemServiceImpl.retrieveAllItems();
		assertThat(itemList, is(empty()));
	}

	@Test
	public void shouldUpdateMenuAndVerifyIfMenuItemsAreRemoved() {
		// Create Menu Object
		Menu menu = new Menu();
		menu.setMenuName("Pizza Pies");
		menu.setCreatedAt(new Date(2017, 04, 22));
		Integer id = menuServiceImpl.createMenu(menu);

		// Update Menu With Item List
		menu = menuServiceImpl.retrieveMenu(id);
		menu.setMenuItems(createListOfItems());
		menuServiceImpl.updateMenu(menu);
		menu = menuServiceImpl.retrieveMenu(id);
		assertThat(menu.getMenuItems().size(), is(2));
		
		// Get All Items
		itemList = itemServiceImpl.retrieveAllItems();
		assertThat(itemList.size(), is(2));

		// Remove Menu And Verify That There Are No Items
		menuServiceImpl.deleteMenu(id);
		itemList = itemServiceImpl.retrieveAllItems();
		assertThat(itemList.size(), is(0));
	}

	@Test
	public void shouldUpdateItem() {
		// Create Item Object
		Item item = createListOfItems().get(0);
		Integer id  = itemServiceImpl.createItem(item);

		// Update Item And Verify If It Was Updated
		item = itemServiceImpl.retrieveItem(id);
		item.setPrice(BigDecimal.valueOf(59.99));
		itemServiceImpl.updateItem(item);
		item = itemServiceImpl.retrieveItem(id);
		assertThat(item.getPrice(), is(BigDecimal.valueOf(59.99)));
		itemServiceImpl.deleteItem(id);
	}
}
