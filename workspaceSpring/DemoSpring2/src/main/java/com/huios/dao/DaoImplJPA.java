package com.huios.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huios.metier.User;
@Repository
@Transactional
public class DaoImplJPA implements IDao {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("AJOUTER A PARTIR DE JPA");
		entityManager.persist(u);
	}

	@Override
	public List<User> listerUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimerUser(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User trouverUser(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listerParMC(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User listerParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
