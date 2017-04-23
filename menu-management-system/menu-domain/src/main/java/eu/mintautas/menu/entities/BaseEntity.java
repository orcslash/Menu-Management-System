package eu.mintautas.menu.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/**
 * {@link Entity} class is most base entity in application.
 * @author mkiulkys
 * @version 1.0
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1823770521633322491L;

	@Id
	@GeneratedValue
	@Column(name = "ENTITY_ID")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}