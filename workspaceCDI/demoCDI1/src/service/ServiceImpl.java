package service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import dao.IDao;

public class ServiceImpl implements Iservice {

	@Inject
	private IDao dao;
	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		return dao.appelDao();
	}

	@PostConstruct
	public void logApresConstruction()
	{
		System.out.println("Après creation Service");
	}
	
	@PreDestroy
	public void logAvantDestruction()
	{
		System.out.println("Avant destruction Service");
	}
}
