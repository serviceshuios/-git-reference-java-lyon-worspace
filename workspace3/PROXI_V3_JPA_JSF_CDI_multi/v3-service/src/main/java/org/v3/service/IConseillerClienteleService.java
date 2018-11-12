package org.v3.service;

import java.util.Collection;

import org.v3.metier.Client;
import org.v3.metier.Compte;
import org.v3.metier.ConseillerClientele;
import org.v3.metier.Credit;
import org.v3.service.exceptions.CompteInvalideException;
import org.v3.service.exceptions.MontantNegatifException;
import org.v3.service.exceptions.NombreMaxClientsParConseillerException;
import org.v3.service.exceptions.SoldeInsuffisantException;



/**
 * Interface ConseillerClienteleService faisant appel aux m�thodes d'Ajout/Modification/Suppression/Affichage d'un client par un conseiller client�le
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public interface IConseillerClienteleService {

	/** S'AUTHENTIFIER */
	public ConseillerClientele authentifier(String login, String password);
	
	public ConseillerClientele chercherConseiller(int id);
	
	/** LISTER CLIENTS */
	public Collection<Client> listerClient (ConseillerClientele conseiller);
	
	/** AJOUTER CLIENT */
	public void ajouterClient(ConseillerClientele conseiller, Client client) throws NombreMaxClientsParConseillerException;
	//public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient, boolean estSociete, String nomSociete);
	//public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient);
	
	/** MODIFIER CLIENT */
	//public void modifierClient(ConseillerClientele conseiller, Client client, int id, String civilite, String nom, String prenom, String rue, String codePostal, String ville, String telephone, String email, String nomEntreprise);
	public void modifierClient(Client client);

	/** RECHERCHER CLIENT */
	public Client chercherClient(int id); // retrouver un client � partir de son id
	public Collection<Client> chercherParMC(String mc); // chercher clients par mot cl� (par nom)
	//public SortedSet<Client> chercherParMC(String mc); // chercher clients par mot cl� (par nom)
	
	/** SUPPRIMER CLIENT */
	public void supprimerClient(ConseillerClientele conseiller, Client client);
	
	/** GERER COMPTES */
	//public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde, Date dateOuverture);
	//public boolean creerCompteCourant(Client client, String numero, float solde, Date dateOuverture, boolean compteEntreprise);
	//public boolean creerCompteEpargne(Client client, String numero, float soldeDepart, Date dateOuverture, boolean compteEntreprise);
	public boolean effectuerVirement(Compte compteADebiter, Compte compteACrediter, double montant) throws SoldeInsuffisantException, MontantNegatifException, CompteInvalideException;
	//public void effectuerPlacementBourse(Client client, Compte compte, PlacementBourse placement, double montant) throws ClientNonFortuneException, SoldeInsuffisantException, MontantNegatifException;
	//public boolean supprimerCompte(Conseiller conseiller, Client client, String typeCompte);
	public Compte chercherCompte(int id);
	
	public Collection<Compte> listerComptes();
	
	
	/** CREDIT */
	public double[] simulerCredit(Credit c) throws MontantNegatifException;
	//public void simulerCreditImmobilier(Client client, CreditImmobilier creditImmo);
	//public void simulerCreditConsommation(Client client, CreditConsommation creditConso);

	
	
	
	
	
	
	
	
}