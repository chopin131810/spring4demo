/**
 * 
 */
package hello.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hello.dao.JpaPersonDao;
import hello.entity.Person;;

/**
 * @author banhbaochay
 *
 */
public class JpaPersonDaoImpl implements JpaPersonDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Person> findAll() {
		return entityManager.createQuery("from Person").getResultList();
	}

	@Override
	public Person findById(Integer id) {
		return (Person) entityManager.createQuery("from Person where id = :id")
				.setParameter("id", id)
				.getResultList()
				.stream().findFirst().get();
	}

}
