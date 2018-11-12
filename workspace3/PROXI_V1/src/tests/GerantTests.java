package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import org.junit.Test;

import metier.Agence;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.Conseiller;
import metier.Gerant;
import service.IGerant;
import service.IGerantImpl;

public class GerantTests {

	@Test
	public void testRealiserAudit() {
		Agence a = new Agence("la source", new Date());
		Gerant g = new Gerant("christian", "eddy", "Mr", a);
		
		Conseiller cons1 = new Conseiller("cons1", "prenom cons1", "Mr");
		Conseiller cons2 = new Conseiller("cons2", "prenom cons2", "Mlle");
		
		Client cl1 = new Client("shirel", "chriss", "MLLE", "GFDR1");
		//Client cl2 = new Client("yeiel", "chriss", "MR", "GFDR2");

		Compte c1 = new CompteCourant("ZERAY", -15000, new Date(), false, cl1);
		Compte c2 = new CompteCourant("ZERAY", -15000, new Date(), false, cl1);
		cl1.setCompteCourant((CompteCourant)c1);
		cl1.setCompteCourant((CompteCourant)c2);
		
		Collection<Conseiller> listeConseillers = new ArrayList<Conseiller>();
		Collection<Client> listeClients = new ArrayList<Client>();
		listeConseillers.add(cons1);
		listeConseillers.add(cons2);
		listeClients.add(cl1);
		a.setGerant(g);
		g.setAgence(a);
		g.setListeClients(listeClients);
		
		g.setListeConseillers(listeConseillers);
		IGerant service = new IGerantImpl();

		assertEquals(true, service.realiserAudit(g).size()==1);
	}

}
