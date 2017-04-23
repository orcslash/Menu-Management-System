package com.mintautas.menu.services.impl;

import static eu.mintautas.menu.services.utils.ServiceTestUtils.createListOfItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsEmptyCollection.empty;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import eu.mintautas.menu.entities.Menu;
import eu.mintautas.menu.service.impl.MenuServiceImpl;
/**
 * Integration tests for {@link MenuServiceImpl} class.
 * @author mkiulkys
 * @since 2017-04-22
 */
@ContextConfiguration(locations = { "classpath*:META-INF/spring/*-config.xml" })
@SuppressWarnings("deprecation")
public class MenuServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final String PIZZA_FRIES = "Pizza Fries";

	@Autowired
	private MenuServiceImpl menuServiceImpl;

	private Menu menu;
	private List<Menu> menuList;

	@Before
	public void setUp() {
		menu = new Menu();
		menu.setMenuName("Pizza Pies");
		menu.setCreatedAt(new Date(2017, 04, 22));
	}

	@Test
	public void shouldCreateMenuAndRemoveItFromDB() {
		// Creates Menu And Retrieves It
		menuServiceImpl.createMenu(menu);
		menuList = menuServiceImpl.retrieveAllMenus();
		assertThat(menuList.size(), is(1));

		// Deletes Menu And Asserts Its Removal
		menuServiceImpl.deleteMenu(menuList.get(0).getId());
		menuList = menuServiceImpl.retrieveAllMenus();
		assertThat(menuList, is(empty()));
	}

	@Test
	public void shouldUpdateExistingMenu() {
		// Updates Existing Menu
		Integer id = menuServiceImpl.createMenu(menu);
		Menu menu = menuServiceImpl.retrieveMenu(id);
		menu.setMenuName(PIZZA_FRIES);
		menuServiceImpl.updateMenu(menu);

		// Updates Menu And Asserts If Value Is Updated
		Menu updatedMenu = menuServiceImpl.retrieveMenu(id);
		assertThat(updatedMenu.getMenuName(), is(PIZZA_FRIES));
		menuServiceImpl.deleteMenu(id);
	}

	@Test
	public void shouldSaveMenuWithItemList() {
		// Save Menu With Two Menu Items
		menu.setMenuItems(createListOfItems());
		Integer id = menuServiceImpl.createMenu(menu);

		// Find Menu And Assert That It Has Two Items
		Menu menuWithItems = menuServiceImpl.retrieveMenu(id);
		assertThat(menuWithItems.getMenuItems().size(), is(2));
		menuServiceImpl.deleteMenu(id);
	}

	@Test
	public void shouldUpdateMenuWithItemList() {
		// Save Menu With No Items
		Integer id = menuServiceImpl.createMenu(menu);

		// Retrieve Menu And Add Items To Its List
		menu = menuServiceImpl.retrieveMenu(id);
		menu.setMenuItems(createListOfItems());
		menuServiceImpl.updateMenu(menu);

		// Find Menu And Assert That It Has Two Items
		Menu menuWithItems = menuServiceImpl.retrieveMenu(id);
		assertThat(menuWithItems.getMenuItems().size(), is(2));
		menuServiceImpl.deleteMenu(id);
	}
}