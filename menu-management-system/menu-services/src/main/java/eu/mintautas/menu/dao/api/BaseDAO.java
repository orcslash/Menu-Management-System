package eu.mintautas.menu.dao.api;
/**
 * {@link BaseDAO} interface is a code standard for base operations.
 * @author mkiulkys
 * @version 1.0
 */
public interface BaseDAO<T> {
	/**
	 * Takes object with set of properties and saves
	 * it to data base.
	 * @param object instance with properties.
	 * @return Id of a created instance.
	 */
	Integer create(T object);

	/**
	 * Returns an object by given id.
	 * @param id of an object to return.
	 * @return Object returned by given id.
	 */
	T retrieve(Integer id);

	/**
	 * Updates an object with new given properties.
	 * @param object with new values.
	 */
	void update(T object);

	/**
	 * Deletes existing object from database.
	 * @param id of an object to delete.
	 */
	void delete(Integer id);
}