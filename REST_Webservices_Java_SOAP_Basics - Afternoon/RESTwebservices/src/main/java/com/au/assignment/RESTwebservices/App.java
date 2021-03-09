package com.au.assignment.RESTwebservices;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.au.assignment.RESTwebservices.service.PersonServiceImpl;

/**
 * Hello world!
 *
 */
public class App extends Application {
	
	private Set<Object> singletons = new HashSet<Object>();

	public App() {
		singletons.add(new PersonServiceImpl());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

}
