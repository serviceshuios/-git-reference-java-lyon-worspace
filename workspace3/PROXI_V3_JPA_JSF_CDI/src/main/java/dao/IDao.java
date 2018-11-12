package dao;

import java.util.Collection;

import metier.Agence;
import metier.Client;
import metier.Compte;
import metier.ConseillerClientele;

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
