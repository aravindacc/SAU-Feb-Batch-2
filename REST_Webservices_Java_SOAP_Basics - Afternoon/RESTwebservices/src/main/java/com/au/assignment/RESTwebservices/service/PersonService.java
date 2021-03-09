package com.au.assignment.RESTwebservices.service;

import com.au.assignment.RESTwebservices.model.Person;
import com.au.assignment.RESTwebservices.model.Response;

public interface PersonService {

	public Response addPerson(Person p);
	
	public Response deletePerson(int id);
	
	public Person getPerson(int id);
	
	public Person[] getAllPersons();

}
