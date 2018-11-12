package dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Client;

@Named
@ApplicationScoped
public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpacdi-pu");
	@Override
	public long addClient(Client c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
		em.close();
		return c.getId();
	}
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		List<Client> clients;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		clients = em.createQuery("select f from Client f").getResultList();
		em.close();
		return clients;
	}
	@Override
	public void delete(Client c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		//em.remove(em.contains(c) ? c : em.merge(c)) ;
		em.remove(em.find(Client.class, c.getId()));
		tx.commit();
		em.close();
	}
	@Override
	public void maj(Client c) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
		em.close();
	}

}
