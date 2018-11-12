package service;

import java.util.ArrayList;
import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Client;
import metier.Compte;
import metier.CompteCourant;
import metier.CompteEpargne;
import metier.Conseiller;

public class Services implements IConseillerService, ILoginService {

	private IDao iDao = new Dao();

	@Override
	public Conseiller verificationLogin(String login, String pwd) {
	
		return iDao.verificationLogin(login, pwd);
	}

	@Override
	public Collection<Client> listerClients(Conseiller conseiller) {
		return iDao.listerClientsParConseiller(conseiller.getIdConseiller());
	}

	@Override
	public Client afficherClient(Conseiller conseiller, int id) {
		Client c = iDao.retourneClientParId(id);
		Collection<Client> clients = iDao.listerClientsParConseiller(conseiller.getIdConseiller());
		for (Client client : clients) {
			if (client.getIdClient() == c.getIdClient()) {
				c.setConseiller(conseiller);
				return c;
			}
		}
		return new Client();
	}

	@Override
	public boolean modifierClient(Conseiller conseiller, int idClient, String nom, String prenom, String email,
			String adresse, String codePostal, String ville, String telephone) {
		Collection<Client> clients = iDao.listerClientsParConseiller(conseiller.getIdConseiller());
		for (Client c : clients) {
			if (c.getIdClient() == idClient) {
				Client client = new Client();
				client.setConseiller(conseiller);
				client.setIdClient(idClient);
				client.setNom(nom);
				client.setPrenom(prenom);
				client.setAdresse(adresse);
				client.setCodePostal(codePostal);
				client.setVille(ville);
				client.setTelephone(telephone);
				client.setEmail(email);
				if (iDao.modifierClient(client) == 1) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean effectuerVirement(Conseiller conseiller, Client client, Compte compteCred, Compte compteDeb,
			double montant) {
		if (client.getConseiller().getIdConseiller() == conseiller.getIdConseiller()) {
	
			double s = compteDeb.getSolde();
			compteDeb = debiterCompte(compteDeb, montant); // debite un compte
			// verification que le debit a eu lieu
			if (s != compteDeb.getSolde()) {
				iDao.modifierCompte(compteDeb);
				compteCred = crediterCompte(compteCred, montant); // credite un
																	// compte
				iDao.modifierCompte(compteCred);
				return true;
			}
	
		}
		return false;
	}

	@Override
	public Compte recupererCompteParId(int id) {
		return iDao.getCompteParId(id);
	}

	@Override
	public Collection<Compte> recupererAutresComptes(Compte compte) {
		Collection<Compte> comptes = iDao.listerComptes();
		for (Compte c : comptes) {
			if (c.getIdCompte() == compte.getIdCompte()) {
				comptes.remove(c);
				return comptes;
			}

		}

		return new ArrayList<Compte>();
	}

	@Override
	public Conseiller afficherConseiller(int idConseiller) {
		return iDao.afficherConseiller(idConseiller);
	}

	/*
	 * PAS ENCORE IMPLEMENTEES
	 */

	@Override
	public boolean creerClient(Conseiller conseiller, Client client) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void supprimerClient(Conseiller conseiller, Client client) {
		// TODO Auto-generated method stub

	}

	/*
	 * PAS ENCORE IMPLEMENTEES
	 */
	
	/**
	 * Methode permettant de crediter un compte
	 * 
	 * @param c
	 *            Compte a crediter
	 * @param montant
	 *            Montant a Crediter sur le compte
	 * @return retourne le compte cr�dit�
	 */
	public Compte crediterCompte(Compte c, double montant) {
		if (montant >= 0) {
			double solde = c.getSolde();
			solde = solde + montant;
			c.setSolde(solde);
	
		}
		return c;
	}

	/**
	 * Methode permetant de debiter un compte
	 * 
	 * @param c
	 *            Compte a debiter
	 * @param montant
	 *            Montant a debiter
	 * @return retourne le compte
	 */
	public Compte debiterCompte(Compte c, double montant) {
	
		// si compte Courant (avec decouvert)
		if (c instanceof CompteCourant) {
			double solde = c.getSolde();
			double decouvert = ((CompteCourant) c).getDecouvert();
			if (montant >= 0) {
				if (solde + decouvert >= montant) {
					solde = solde - montant;
					c.setSolde(solde); // debite le comptecourant
				}
	
			}
			return c;
	
		}
		// si compte Epargne (Sans decouvert)
		if (c instanceof CompteEpargne) {
			double solde = c.getSolde();
			if (montant >= 0) {
				if (solde >= montant) {
					solde = solde - montant;
					c.setSolde(solde); // debite le compte Epargne
				}
	
			}
			return c;
		}
		return c;
	}

}
