package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IPersonDao;
import com.exception.PersonAlreadyExists;
import com.exception.PersonNotFound;
import com.model.Person;

@Service
public class PersonService implements IPersonService {

	@Autowired
	IPersonDao personDao;

	@Override
	public List<Person> getAllPersons() {
		return personDao.getAllPersons();
	}

	@Override
	public Person addPerson(Person person) throws PersonAlreadyExists {
		Optional<Person> optional = personDao.findById(person.getId());
		if (!optional.isPresent()) {
			personDao.addPerson(person);
			return person;
		}
		throw new PersonAlreadyExists();
	}

	@Override
	public Person deletePerson(Short id) throws PersonNotFound {
		if (personDao.findById(id).isPresent()) {
			personDao.deletePerson(id);
			return new Person();
		}
		throw new PersonNotFound();
	}

	@Override
	public Person updatePerson(Person person) throws PersonNotFound {
		if (personDao.findById(person.getId()).isPresent()) {
			personDao.updatePerson(person);
			return person;
		}
		throw new PersonNotFound();
	}

}
