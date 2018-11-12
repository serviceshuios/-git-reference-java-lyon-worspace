package com.huios;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.User;
import com.huios.service.Iservice;

public class Lanceur {

	public static void main(String[] args) {
		//1- Chargement du container et creation des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		//2- récupération des beans
		Iservice service = (Iservice) appContext.getBean("serviceImpl");
		User user = (User) appContext.getBean("user");
		user.setNom("testSpringData");
		user.setPrenom("testSpringData");
		User user2 = (User) appContext.getBean("user");
		System.out.println("bean user="+user.getNom());
		System.out.println("bean user2="+user2.getNom());
		
		//3- utilisation des beans
		service.ajouterUser(user);
		//service.supprimerUser(1L);
		List<User> liste = service.listerUsers();
		for(User u : liste)
		{
			System.out.println(u);
		}
		//System.out.println(service.trouverUser(1L));
		
		//4- fermeture du contexte
		appContext.close();
	}

}
