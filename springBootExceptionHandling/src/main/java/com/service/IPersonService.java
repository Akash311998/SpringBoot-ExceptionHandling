package com.service;

import java.util.List;

import com.exception.PersonAlreadyExists;
import com.exception.PersonNotFound;
import com.model.Person;

public interface IPersonService {
	
	public List<Person> getAllPersons();
	
	public Person addPerson(Person person) throws  PersonAlreadyExists;

	public Person deletePerson(Short id) throws PersonNotFound;

	public Person updatePerson(Person person) throws PersonNotFound ;


}
