/**
 * 
 */
package hello.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.dao.HibernatePersonDao;
import hello.dao.PersonRepository;
import hello.entity.Person;

/**
 * @author banhbaochay
 *
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private PersonRepository personRepo;
	
	@Autowired
	private HibernatePersonDao dao;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Person> findAll() {
		return StreamSupport.stream(personRepo.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/{personId}", method = RequestMethod.GET)
	public Person findById(@PathVariable Integer personId) {
		return dao.findById(personId);
	}
}
