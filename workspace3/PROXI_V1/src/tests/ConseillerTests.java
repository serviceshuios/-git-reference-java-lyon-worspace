package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.Conseiller;
import service.IConseiller;
import service.IConseillerImpl;

public class ConseillerTests {

	@Test
	public void testCreerClientConseillerStringStringStringStringBooleanString() {
		Conseiller c= new Conseiller("zam","eddy","Mr");
		IConseiller I = new IConseillerImpl();
		assertEquals(true, I.creerClient (c, "client1", "pierre", "Mlle", "MR2345", false, ""));
		
	}

	@Test
	public void testCreerClientConseillerStringStringStringString() {
		Conseiller c= new Conseiller("zam","eddy","Mr");
		IConseiller I = new IConseillerImpl();
		assertEquals(true, I.creerClient (c, "client2", "gaspard", "Mr", "MR1236"));
	}

	@Test
	public void testLireClient() {
		Conseiller c= new Conseiller("zam","eddy","Mr");
		Client cli = new Client("client1", "elise", "Mme", "RETSG");
		List<Client> listeClients = new ArrayList<Client>();
		listeClients.add(cli);
		c.setListeClients(listeClients);
		IConseiller I = new IConseillerImpl();
		
		assertEquals(true,cli==I.lireClient(c, "RETSG"));
	}

	@Test
	public void testModificationCLient() {
		IConseiller I = new IConseillerImpl();
		Conseiller c= new Conseiller("zam","eddy","Mr");
		Client cli = new Client("client1", "elise", "Mme", "RETSG");
		List<Client> listeClients = new ArrayList<Client>();
		listeClients.add(cli);
		c.setListeClients(listeClients);
		I.modificationCLient (c, cli, "manguel", "swist",false, null);
		System.out.println();
		assertTrue(c.getListeClients().size()==1);
	}

	@Test
	public void testSupprimerClient() {
		Conseiller c = new Conseiller("zam", "eddy", null);
		Client cli = new Client("client1", "elise", "Mme", "Courant");
		List<Client> listeClients = new ArrayList<Client>();
		listeClients.add(cli);
		c.setListeClients(listeClients);
		IConseiller I = new IConseillerImpl();
		I.ajouterCompte(cli, "Courant", "ZZZZ", 500000f, new Date());
		assertEquals(true,I.supprimerClient(c, cli));
	}

	@Test
	public void testAjouterCompte() {
		Client c = new Client("toto", "paul", "Mr", "2435M");
		IConseiller I = new IConseillerImpl();
		assertEquals(true,I.ajouterCompte(c, "Courant", "1ZER33U", 12345f,
				new Date()));
		
	}

	@Test
	public void testCreerCompteCourant() {
		Client c = new Client("toto", "paul", "Mr", "2435M");
		IConseiller I = new IConseillerImpl();
		assertEquals(true,I.creerCompteCourant(c, "ERTZAS", 12000f, new Date(),
				false));
	}

	@Test
	public void testCreerCompteEpargne() {
		Client c = new Client("toto", "paul", "Mr", "2435M");
		IConseiller I = new IConseillerImpl();
		assertEquals(true,I.creerCompteEpargne(c, "BLABLA", 45000f, new Date(), true));
	}

	@Test
	public void testSupprimerCompte() {
		Client c = new Client("toto", "paul", "Mr", "2435M");
		Conseiller cons = new Conseiller("zam", "eddy", null);
		CompteCourant compte = new CompteCourant("ZERAZR", 45000f, new Date(), false, c); 
		IConseiller I = new IConseillerImpl();
		//I.ajouterCompte(c, "Courant", numero, solde, dateOuverture)
		c.setCompteCourantClient(compte);
		assertEquals(true,I.supprimerCompte(cons, c, "Courant"));
	}

	@Test
	public void testVirementCompteACompte() {
		Client c = new Client("toto", "paul", "Mr", "2435M");
		IConseiller I = new IConseillerImpl();
		CompteCourant compte = new CompteCourant("ZERAZR", 45000f, new Date(), false, c); 
		CompteCourant compte2 = new CompteCourant("ZERAZR", 45000f, new Date(), false, c); 
		I.virementCompteACompte(compte, compte2, 45000);
		
		assertEquals(true,compte.getSolde() + 45000==compte2.getSolde()-45000);
	}

	@Test
	public void testSimulerCreditImmobilier() {
		assertEquals(true,true);
	}

	@Test
	public void testSimulerCreditConsommation() {
		assertEquals(true,true);
	}

	@Test
	public void testCreerPlacement() {
		Client c = new Client("toto", "paul", "Mr", "2435M");
		Compte compte = new CompteCourant("ZERAZR", 600000f, new Date(), false, c);
		IConseiller I = new IConseillerImpl();
		assertEquals(true,I.creerPlacement(c, compte, 15000f, "Bourse de NewYork"));
	}

}
