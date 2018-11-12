package dao;

import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import metier.Agence;
import metier.Client;
import metier.Compte;
import metier.ConseillerClientele;

@Named
@ApplicationScoped
public class Dao implements IDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");

	/**
	 * authentifie un conseiller clientelle, renvoie le conseiller si
	 * l'authentification est correcte, null dans le cas contraire
	 */
	@Override
	public ConseillerClientele authentifier(String login, String password) {

		ConseillerClientele cc = null;

		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT cc FROM Personne cc WHERE cc.email = :email AND cc.password = :password");

		q.setParameter("email", login);
		q.setParameter("password", password);

		try {
			cc = (ConseillerClientele) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();

		return cc;
	}

	/**
	 * renvoie la liste des clients d'un conseiller
	 */
	@Override
	public Collection<Client> listerClientsConseiller(ConseillerClientele conseillerClientele) {

		Collection<Client> clients = new ArrayList<Client>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT c FROM Personne c WHERE c.monConseiller = :conseillerClientele");

		q.setParameter("conseillerClientele", conseillerClientele);

		try {
			clients = q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		em.close();

		return clients;
	}

	@Override
	public Collection<Client> listerClientsAgence(Agence agence) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ajoute un client en bdd retourne 1 si l'ajout fonctionne 0 dans le cas
	 * contraire
	 */
	@Override
	public int ajouterClient(Client c) {

		int nbInsert = 0;

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.persist(c);
			nbInsert = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		tx.commit();
		em.close();

		return nbInsert;
	}

	/**
	 * modifie un client de la base de données, renvoie 1 si la modif est
	 * accomplie, dans le cas contraire
	 */
	@Override
	public int modifierClient(Client c) {

		int nbModified = 0;

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.merge(c);
			nbModified = 1;
		} catch (Exception e) {

			e.printStackTrace();
		}

		tx.commit();
		em.close();

		return nbModified;
	}

	@Override
	public Client chercherClient(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Client> chercherClientParMC(String mc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int supprimerClient(Client c) {

		int nbSuppr = 0;

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.remove(em.contains(c) ? c : em.merge(c));
			nbSuppr = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}

		tx.commit();
		em.close();

		return nbSuppr;
	}

	/**
	 * modifie un conseiller de données, renvoie 1 si la modif est accomplie,
	 * dans le cas contraire
	 */
	@Override
	public int miseAJourConseiller(ConseillerClientele c) {

		int nbModified = 0;

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			em.merge(c);
			nbModified = 1;
		} catch (Exception e) {

			e.printStackTrace();
		}

		tx.commit();
		em.close();

		return nbModified;
	}

	public ConseillerClientele template(Client c) {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(c) ? c : em.merge(c));
		tx.commit();
		em.close();

		return null;
	}

	@Override
	public Compte chercherCompte(int id) {

		Compte c;

		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT c FROM Compte c WHERE c.id = :id");

		q.setParameter("id", id);

		c = (Compte) q.getSingleResult();

		em.close();

		return c;
	}

	@Override
	public Collection<Compte> listerComptes() {

		Collection<Compte> comptes = new ArrayList<Compte>();

		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT c FROM Compte c");
		comptes = q.getResultList();

		em.close();

		return comptes;
	}

	/**
	 * met à jour les deux comptes du virement
	 */
	@Override
	public int executerVirement(Compte compteADebiter, Compte compteACrediter) {

		int nbModified = 0;

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.merge(compteADebiter);
		nbModified += 1;
		em.merge(compteACrediter);
		nbModified += 1;

		tx.commit();
		em.close();

		return nbModified;
	}

	@Override
	public ConseillerClientele chercherConseiller(int id) {
		
		ConseillerClientele cc;

		EntityManager em = emf.createEntityManager();

		Query q = em.createQuery("SELECT cc FROM ConseillerClientele cc WHERE cc.id = :id");

		q.setParameter("id", id);

		cc = (ConseillerClientele) q.getSingleResult();

		em.close();

		return cc;

	}

}
