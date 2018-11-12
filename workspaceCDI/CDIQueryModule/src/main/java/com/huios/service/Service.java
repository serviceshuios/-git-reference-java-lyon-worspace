package com.huios.service;

import org.jboss.arquillian.core.api.annotation.Inject;

import com.huios.dao.PersonneRepository;
import com.huios.metier.Personne;

public class Service implements Iservice {

	@Inject
	PersonneRepository personneRepository;
	
	@Override
	public void addPersonne(Personne p) {
		personneRepository.save(p);
	}

}
