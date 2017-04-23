package eu.mintautas.menu.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
/**
 * {@link Item} class instance can be added to a specific menu.
 * @author mkiulkys
 * @version 1.0
 */
@Entity
@Table(name = "ITEM")
public class Item extends BaseEntity {

	private static final long serialVersionUID = 2823770521633322491L;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "NAME")
	private String itemName;

	@Column(name = "SIZE")
	private String size;

	@Column(name = "TYPE")
	private String type;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}