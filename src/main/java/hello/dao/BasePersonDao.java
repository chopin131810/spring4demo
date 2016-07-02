package hello.dao;

import java.util.List;

import hello.entity.Person;

/**
 * Base interface for Person DAO. Currently there're 3 interfaces extends from it: HibernateCriteria, Hibernate and JPA
 * @author banhbaochay
 *
 */
public interface BasePersonDao {
	/**
	 * Find All persons. Repository of spring-data doesn't need to implement
	 * @return
	 */
	List<Person> findAll();
	
	/**
	 * Find person by id. Repository of spring-data doesn't need to implement
	 * @param id
	 * @return
	 */
	Person findById(Integer id);
}
