package eu.mintautas.menu.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * {@link Menu} class represents a distinct menu a restaurant can have.
 * @author mkiulkys
 * @version 1.0
 */
@Entity
@Table(name = "MENU")
public class Menu extends BaseEntity {

	private static final long serialVersionUID = 1823770521633322491L;

	@Column(name = "NAME")
	private String menuName;

	@Column(name = "CREATED_AT")
	private Date createdAt;

	@Column(name = "MENU_ITEMS")
	@OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Item> menuItems;

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<Item> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<Item> menuItems) {
		this.menuItems = menuItems;
	}
}