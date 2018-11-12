package com.huios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huios.dao.IDao;
import com.huios.dao.springdata.UserRepository;
import com.huios.metier.User;
@Service
public class ServiceImpl implements Iservice {

	@Autowired
	//@Qualifier("daoImplJPA")
	//@Qualifier("daoImplHibernate")
	//private IDao dao;
	UserRepository userRepository;
	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		//dao.ajouterUser(u);
		userRepository.save(u);
	}

	@Override
	public List<User> listerUsers() {
		// TODO Auto-generated method stub
		//return dao.listerUsers();
		return userRepository.findAll();
	}

	@Override
	public void supprimerUser(long id) {
		// TODO Auto-generated method stub
		//dao.supprimerUser(id);
		userRepository.delete(id);
	}

	@Override
	public User trouverUser(long id) {
		// TODO Auto-generated method stub
		//return dao.trouverUser(id);
		return userRepository.findOne(id);
	}

	@Override
	public List<User> listerParMC(String mc) {
		// TODO Auto-generated method stub
		//return dao.listerParMC(nom);
		return userRepository.findByMC(mc);
	}

	@Override
	public User listerParNom(String nom) {
		// TODO Auto-generated method stub
		//return dao.listerParNom(nom);
		return userRepository.findFistByNom(nom);
	}

}
