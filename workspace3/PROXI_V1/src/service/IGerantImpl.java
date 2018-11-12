package service;

import metier.*;
import java.util.*;

/**
 * Cette classe permet au gerant de realiser un audit de son agence. Cet audit
 * consiste a verifier le solde de tous les comptes clients. Si celui ci est trop
 * important ils sont ajoute aа la liste des clients debiteur. Cette liste est
 * retourne par cette fonction.
 * 
 * @author Eddy
 *
 */
public class IGerantImpl implements IGerant {

	/**
	 *  La methode permet de realiser un audit sur la totalite des clients de l'agence et retounre une liste de Clients debiteur
	 * @param gerant Le gerant de l'agence
	 * @return Liste de client dont le debit est trop important
	 */
	public Collection<Client> realiserAudit(Gerant gerant) {

		Collection<Conseiller> listeConseillers = gerant.getListeConseillers();
		Collection<Client> clientDebiteur = new ArrayList<Client>();

		listeConseillers.add(gerant);
		int seuil;

		// On realise l'ensemble des tests pour l'audit pour l'ensemble des
		// conseillers
		for (Conseiller k : listeConseillers) {

			// On realise l'ensemble des tests de l'audits pour l'ensemble des
			// clients pour chaque conseiller
			for (Client temp : k.getListeClients()) {

				// Calcule le seuil ра partir duquel le client est considere
				// comme debiteur: 2 cas: client entreprise et client normal
				if (temp.estSociete())
					seuil = -50000;
				else
					seuil = -5000;
				
				// Si le client possede un compte courant et un compte d'epargne
				if (temp.getCompteCourantClient() != null && temp.getCompteEpargneClient() != null) {

					if (temp.getCompteCourantClient().getSolde() + temp.getCompteEpargneClient().getSolde() <= seuil)
						clientDebiteur.add(temp);
				}
				
				// Si le client possede uniquement un compte Courant
				if (temp.getCompteEpargneClient() == null) {

					if (temp.getCompteCourantClient().getSolde() <= seuil)
						clientDebiteur.add(temp);
				}
				
				// Si le client possede uniquement un compte Epargne
				if (temp.getCompteCourantClient() == null) {

					if (temp.getCompteEpargneClient().getSolde() <= seuil)
						clientDebiteur.add(temp);
				}
			}
		}
		return clientDebiteur;
	}
}
