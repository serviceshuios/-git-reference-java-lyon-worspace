package service;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

import javax.inject.Inject;
import javax.inject.Named;

import dao.Dao;
import dao.IDao;
import metier.Client;
import metier.Compte;
import metier.ConseillerClientele;
import metier.Credit;
import service.exceptions.CompteInvalideException;
import service.exceptions.MontantNegatifException;
import service.exceptions.NombreMaxClientsParConseillerException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe service ConseillerClienteleService est associ�e � la classe m�tier ConseillerClientele.
 * Elle permet d'effectuer les op�rations sp�cifiques � un conseiller client�le de ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@Named
public class ConseillerClienteleService implements IConseillerClienteleService, Serializable {

	/**
	 * Lien vers la couche Dao
	 */
	@Inject
	private IDao idao; // = new Dao();
	
	/**
	 * M�thode permettant � un conseiller clientele de s'authentifier
	 */
	public ConseillerClientele authentifier(String login, String password) {
		return idao.authentifier(login, password);
	}
	
	/**
	 * M�thode permettant de lister les clients affect�s � un conseiller clientele
	 * @param conseiller : le conseiller client�le
	 * @return la collection de clients du conseiller
	 */
	@Override
	public Collection<Client> listerClient(ConseillerClientele conseiller) {
		return idao.listerClientsConseiller(conseiller);
	}

	/**
	 * M�thode permettant d'ajouter un client
	 * @param conseiller : le conseiller client�le
	 * @param client : le client � ajouter
	 * @throws NombreMaxClientsParConseillerException 
	 */
	@Override
	public void ajouterClient(ConseillerClientele conseiller, Client client) throws NombreMaxClientsParConseillerException {
		if (conseiller.getMesClients().size() < 10) {
			// Ajout du client � la collection de clients du conseiller client�le
			conseiller.getMesClients().add(client);

			// Ajout du client � la collection de clients de l'agence
			//conseiller.getMonAgence().getClientsAgence().add(client);
		} else throw new NombreMaxClientsParConseillerException("VOUS GEREZ DEJA 10 CLIENTS : NOMBRE MAXIMUM DE CLIENTS QUE VOUS POUVEZ GERER ATTEINT");
		
		// Ajout du client en base de donn�e
		idao.ajouterClient(client);
		idao.miseAJourConseiller(conseiller);
	}

	/**
	 * Met a jour un client modifié
	 */
	@Override
	public void modifierClient(Client client) {

		idao.modifierClient(client);
	}

	/**
	 * M�thode permettant de rechercher un client � partir de son identifiant
	 * @param id : l'identifiant � partir duquel on veut rechercher un client
	 * @return le client trouv� � partir de l'identifiant
	 */
	@Override
	public Client chercherClient(int id) {
		return idao.chercherClient(id);
	}

	/**
	 * M�thode permettant de rechercher un client � partir d'un mot cl�
	 * @param mc : le mot cl� � partir duquel on veut rechercher un client
	 * @return le client trouv� � partir du mot cl�
	 */
	@Override
	public Collection<Client> chercherParMC(String mc) {
		return idao.chercherClientParMC(mc);
	}

	/**
	 * M�thode permettant de supprimer un client et les comptes et cartes bancaires associ�es
	 * @param conseiller : le conseiller client�le
	 * @param client : le client � supprimer 
	 */
	@Override
	public void supprimerClient(ConseillerClientele conseiller, Client client) {

		Collection<Client> collectionClientsConseiller = conseiller.getMesClients();
		
		//mise a jour de la liste des clients
		collectionClientsConseiller.remove(client);
		conseiller.setMesClients(collectionClientsConseiller);
		
		// Suppression du client en base de donn�e
		idao.miseAJourConseiller(conseiller);
		idao.supprimerClient(client);
	}
	

	/**
	 * M�thode permettant de faire un virement entre deux comptes bancaires
	 * @param compteADebiter : le compte � d�biter
	 * @param compteACrediter : le compte � cr�diter
	 * @param montant : le montant du virement
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 * @throws CompteInvalideException
	 */
	@Override
	public boolean effectuerVirement(Compte compteADebiter, Compte compteACrediter, double montant)
			throws SoldeInsuffisantException, MontantNegatifException, CompteInvalideException {

		if (compteACrediter.getIdCompte()==compteADebiter.getIdCompte()){
			throw new CompteInvalideException("Les comptes sélectionnées sont les mêmes");
		}
		
		if (montant < 0) {
			throw new MontantNegatifException("Montant négatif");
		} else if (montant > compteADebiter.getSoldeCompte()) {
			throw new SoldeInsuffisantException("Solde insuffisant");
		} else {
				
			compteADebiter.setSoldeCompte(compteADebiter.getSoldeCompte() - montant);
			compteACrediter.setSoldeCompte(compteACrediter.getSoldeCompte() + montant);
			
			idao.executerVirement(compteADebiter, compteACrediter);	
		}
		
		return true;
	}

//	/**
//	 * Methode permettant de faire un placement
//	 * @param client : le client
//	 * @param placement : le placement
//	 * @param montant : le montant du placement
//	 * @throws SoldeInsuffisantException
//	 * @throws MontantNegatifException
//	 * @throws ClientNonFortuneException
//	 */
//	@Override
//	public void effectuerPlacementBourse(Client client, Compte compte, PlacementBourse placement, double montant)
//			throws ClientNonFortuneException, SoldeInsuffisantException, MontantNegatifException {
//		ClientService cs = new ClientService();
//		if (cs.isFortune(client)) {
//			if (montant >= 0){
//				if (client.getCompteEpargne().getSoldeCompte() >= montant){
//					cs.effectuerPlacementBourse(client, placement, montant);
//				} else throw new SoldeInsuffisantException("SOLDE INSUFFISANT SUR COMPTE EPARGNE");
//			} else throw new MontantNegatifException("MONTANT NEGATIF");
//		} else throw new ClientNonFortuneException("IMPOSSIBLE DE PROPOSER UN PLACEMENT A CE CLIENT - PATRIMOINE INSUFFISANT");
//	}

	/**
	 * M�thode permettant de simuler un cr�dit consommation ou un cr�dit immobilier
	 * retourne une estimation du co�t total d'un cr�dit
	 * @param c : le cr�dit consommation ou immobilier
	 * @return le co�t du cr�dit + le montant des mensualit�s
	 */
	@Override
	public double[] simulerCredit(Credit c) throws MontantNegatifException {
		double[] t = {0,0};

		if (c.getMontant() >= 0){
			t[0] = ((c.getMontant()*c.getTaux())/100);		// co�t du cr�dit
			t[1] = ((c.getMontant()+t[0])/c.getDuree());	// montant d'une mensualit�
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return t;
	}

	/**
	 * Permet de retrouver un compte par son id
	 */
	@Override
	public Compte chercherCompte(int id) {

		return idao.chercherCompte(id);
	}

	/**
	 * Permet de lister tous les comptes persités
	 */
	@Override
	public Collection<Compte> listerComptes() {

		return idao.listerComptes();
	}

	/**
	 * Permet de retrouver un conseiller par son id
	 */
	@Override
	public ConseillerClientele chercherConseiller(int id) {

		return idao.chercherConseiller(id);
	}

}
