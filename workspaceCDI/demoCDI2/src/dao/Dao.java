package dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import dao.NotificationTypeDao.TypeDao;

@NotificationTypeDao(TypeDao.JDBC)
public class Dao implements IDao {

	@Override
	public String appelDao() {
		// TODO Auto-generated method stub
		return "Bonjour Je suis bien dans la DAO JDBC";
	}

	@PostConstruct
	public void logApresConstruction()
	{
		System.out.println("Après creation Dao JDBC");
	}
	
	@PreDestroy
	public void logAvantDestruction()
	{
		System.out.println("Avant destruction Dao JBDC");
	}
}
