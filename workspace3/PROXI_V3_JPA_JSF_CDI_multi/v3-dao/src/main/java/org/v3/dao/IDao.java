package org.v3.dao;

import java.util.Collection;

import org.v3.metier.Agence;
import org.v3.metier.Client;
import org.v3.metier.Compte;
import org.v3.metier.ConseillerClientele;



public interface IDao {

	public ConseillerClientele authentifier(String login, String password);
	
	public Collection<Client> listerClientsConseiller(ConseillerClientele conseillerClientele);
	
	
	
	public Collection<Client> listerClientsAgence(Agence agence);
	
	public int ajouterClient(Client c);
	
	public int modifierClient(Client c);
	
	public Client chercherClient(int id); // retrouver un client � partir de son id
	
	public Collection<Client> chercherClientParMC(String mc); // chercher clients par mot cl� (par nom)
	
	public int supprimerClient(Client c);
	
	public int miseAJourConseiller(ConseillerClientele conseiller);
	
	public Compte chercherCompte(int id);
	
	public Collection<Compte> listerComptes();
	
	public int executerVirement(Compte compteADebiter,Compte compteACrediter);
	
	public ConseillerClientele chercherConseiller(int id);
	
	
	
}
