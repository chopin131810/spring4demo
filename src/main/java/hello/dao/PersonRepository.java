/**
 * 
 */
package hello.dao;

import org.springframework.data.repository.CrudRepository;

import hello.entity.Person;

/**
 * This interface uses spring-data technique and has auto-generated method by Spring
 * @author banhbaochay
 *
 */
public interface PersonRepository extends CrudRepository<Person, Integer>  {

}
