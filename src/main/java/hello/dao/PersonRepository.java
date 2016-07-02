/**
 * 
 */
package hello.dao;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Person;

/**
 * @author Welcome
 *
 */
public interface PersonRepository extends CrudRepository<Person, Integer>  {

}
