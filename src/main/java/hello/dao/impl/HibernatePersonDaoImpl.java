/**
 * 
 */
package hello.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hello.dao.HibernatePersonDao;
import hello.entity.Person;

/**
 * @author banhbaochay
 *
 */
@Transactional
@Repository
public class HibernatePersonDaoImpl implements HibernatePersonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Person> findAll() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Person")
				.list();
	}

	@Override
	public Person findById(Integer id) {
		return (Person) sessionFactory.getCurrentSession()
				.createQuery("from Person where id = :id")
				.setParameter("id", id)
				.list()
				.stream()
				.findFirst()
				.get();
	}

}
