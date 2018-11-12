package com.huios.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.huios.metier.User;
@Repository
@Transactional
public class DaoImplHibernate implements IDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void ajouterUser(User u) {
		// TODO Auto-generated method stub
		System.out.println("HIBERNATE");
		getSession().save(u);
	}

	@Override
	public List<User> listerUsers() {
		// TODO Auto-generated method stub
		System.out.println("HIBERNATE");
		String req="from User";
		Query query = getSession().createQuery(req);
		return query.list();
	}

	@Override
	public void supprimerUser(long id) {
		// TODO Auto-generated method stub
		System.out.println("HIBERNATE");
		User u = getSession().get(User.class, id);
		getSession().delete(u);
	}

	@Override
	public User trouverUser(long id) {
		// TODO Auto-generated method stub
		System.out.println("HIBERNATE");
		return getSession().get(User.class, id);
	}

	@Override
	public List<User> listerParMC(String nom) {
		System.out.println("HIBERNATE");
		String req = "from User as u where u.nom like :nom";
		Query query = getSession().createQuery(req);
		query.setParameter("nom", "%"+nom+"%");
		return query.list();
	}

	@Override
	public User listerParNom(String nom) {
		// TODO Auto-generated method stub
		System.out.println("HIBERNATE");
		String req = "from User as u where u.nom like :nom";
		Query query = getSession().createQuery(req);
		query.setParameter("nom", nom);
		//par contre uniqueResult() ne marche pas lorsqu'il y a plusieurs résultats
		// donc on mets le max des résultats à 1 avant
		query.setMaxResults(1);
		return (User) query.uniqueResult();
	}

}
