package com.huios.dao.springdata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.huios.metier.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//public User findByNom(String nom);
	public User findFistByNom(String nom);
	
	@Query("select u from User u where u.nom like %?1%")
	public List<User> findByMC(String mc);
}
