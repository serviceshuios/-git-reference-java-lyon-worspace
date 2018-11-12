package com.huios.DemoSpring1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestInjection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1- Chargement du container et creation des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2- récupération d'un bean
		SocieteDevLogiciel societe = (SocieteDevLogiciel) appContext.getBean("societe");
		//3- traitement
		System.out.println(societe);
		//4- detruire le contexte
		appContext.close();
	}

}
