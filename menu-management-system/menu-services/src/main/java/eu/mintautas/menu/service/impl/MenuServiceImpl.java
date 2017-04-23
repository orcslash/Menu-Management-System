package eu.mintautas.menu.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import eu.mintautas.menu.dao.impl.MenuDAOImpl;
import eu.mintautas.menu.entities.Menu;
import eu.mintautas.menu.service.api.MenuService;
/**
 * @author mkiulkys
 * @version 1.0
 */
@Service(value = "menuService")
@Scope("prototype")
public class MenuServiceImpl implements MenuService {

	private static Logger logger = Logger.getLogger(ItemServiceImpl.class);

	@Autowired
	private MenuDAOImpl menuDAOImpl;

	/**
	 * {@inheritDoc}
	 */
	public Integer createMenu(Menu menu) {
		Integer id = getMenuDAOImpl().create(menu);
		logger.info("Menu added to databese. Id: " + id);
		return id;
	}

	/**
	 * {@inheritDoc}
	 */
	public Menu retrieveMenu(Integer id) {
		Menu menu = getMenuDAOImpl().retrieve(id);
		return menu;
	}

	public void updateMenu(Menu menu) {
		getMenuDAOImpl().update(menu);
		logger.info("Menu was successfully updated. Id: " + menu.getId());
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteMenu(Integer id) {
		getMenuDAOImpl().delete(id);
		logger.info("Menu was successfully deleted. Id: " + id);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<Menu> retrieveAllMenus() {
		List<Menu> menuList = getMenuDAOImpl().retrieveAllMenus();
		if (menuList.isEmpty()) {
			logger.info("No data was found.");
		}
		return menuList;
	}

	public MenuDAOImpl getMenuDAOImpl() {
		return menuDAOImpl;
	}

	public void setMenuDAOImpl(MenuDAOImpl menuDAOImpl) {
		this.menuDAOImpl = menuDAOImpl;
	}
}