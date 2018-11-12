package com.huios;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huios.metier.Stock;
import com.huios.service.Iservice;
import com.huios.service.exceptions.ArticleNotFoundException;
import com.huios.service.exceptions.NotEnoughArticleException;
import com.huios.service.exceptions.QtyNegativeException;


public class Lanceur {

	public static void main(String[] args) throws ArticleNotFoundException, QtyNegativeException, NotEnoughArticleException  {
		// TODO Auto-generated method stub
		//1- Chargement du container et creation des beans
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext
				("applicationContext.xml");
		//2- récupération des beans
		Iservice service = (Iservice) appContext.getBean("serviceImpl");
		Stock s = (Stock)appContext.getBean("stock");
		service.sortArticleDuStock(1, 200);
		appContext.close();
		
	}

}
