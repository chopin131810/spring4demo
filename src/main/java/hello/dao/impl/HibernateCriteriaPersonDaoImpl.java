package hello.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hello.dao.HibernateCriteriaPersonDao;
import hello.entity.Person;

@Transactional
@Repository
public class HibernateCriteriaPersonDaoImpl implements HibernateCriteriaPersonDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Person> findAll() {
		return sessionFactory.getCurrentSession().createCriteria(Person.class).list();
	}

	@Override
	public Person findById(Integer id) {
		return (Person) sessionFactory.getCurrentSession()
				.createCriteria(Person.class)
				.add(Restrictions.idEq(id))
				.list()
				.stream()
				.findFirst().get();
	}

}
