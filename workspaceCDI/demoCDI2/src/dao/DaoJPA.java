package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import dao.NotificationTypeDao.TypeDao;

@NotificationTypeDao(TypeDao.JPA)
public class DaoJPA implements IDao {

	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		return "Bonjour Je suis bien dans la DAO JPA";
	}

	@PostConstruct
	public void logApresConstruction()
	{
		System.out.println("Après creation Dao JPA");
	}
	
	@PreDestroy
	public void logAvantDestruction()
	{
		System.out.println("Avant destruction Dao JPA");
	}

}
