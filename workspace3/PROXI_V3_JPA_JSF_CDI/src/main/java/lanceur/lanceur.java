package lanceur;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.ClientEntreprise;
import metier.ClientParticulier;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.ConseillerClientele;

public class lanceur {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxibanque-pu");

		
		//tests
		
		/** 1er client */
		
		Adresse a1 = new Adresse("1 rue Massena", "00048", "LYON");
		
		CompteCourant cc = new CompteCourant();
		cc.setSoldeCompte(1000);
		cc.setDecouvert(500);
		cc.setDateOuvertureCompte(new Date());
		
		CompteEpargne ce = new CompteEpargne();
		ce.setSoldeCompte(3500);
		ce.setTauxRemuneration(3);
		ce.setDateOuvertureCompte(new Date());
		
		ClientParticulier clientPart = new ClientParticulier();
		clientPart.setAdresse(a1);
		clientPart.setNom("DUPOND");
		clientPart.setPrenom("Laurent");
		clientPart.setCivilite("Monsieur");
		clientPart.setEmail("laurent.dupond@free.net");
		clientPart.setTelephone("0678569874");
		
		clientPart.getMesComptes().add(cc);
		cc.setClientProprietaire(clientPart);
	
		clientPart.getMesComptes().add(ce);
		ce.setClientProprietaire(clientPart);


		/** 2ème client */
		
		Adresse a2 = new Adresse("10 rue Brotteaux", "69006", "LYON");
		
		ClientEntreprise clientEntr = new ClientEntreprise();
		clientEntr.setAdresse(a2);
		clientEntr.setNom("DURAND");
		clientEntr.setPrenom("Marie");
		clientEntr.setCivilite("Madame");
		clientEntr.setEmail("marie.durand@gmail.net");
		clientEntr.setTelephone("0678974518");
		clientEntr.setNomEntreprise("GTM Ingénierie");

		
		/** Conseiller clientèle */
		
		Adresse a3 = new Adresse("10 rue de la Gare", "52147", "MARSEILLE");
		
		ConseillerClientele conseiller = new ConseillerClientele();
		conseiller.setAdresse(a3);
		conseiller.setNom("JAFFRE");
		conseiller.setPrenom("Guy");
		conseiller.setCivilite("Monsieur");
		conseiller.setEmail("guy.jaffre@free.net");
		conseiller.setTelephone("0678974518");
		conseiller.setPassword("test");
		conseiller.getMesClients().add(clientPart);
		conseiller.getMesClients().add(clientEntr);
		
		clientPart.setMonConseiller(conseiller);
		clientEntr.setMonConseiller(conseiller);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(conseiller);
		em.persist(clientPart);
		em.persist(clientEntr);
		
		tx.commit();
		em.close();

	}

}
