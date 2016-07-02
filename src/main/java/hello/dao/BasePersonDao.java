package hello.dao;

import java.util.List;

import hello.entity.Person;

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
