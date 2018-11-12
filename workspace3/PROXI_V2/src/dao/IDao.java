package dao;

import java.util.Collection;

import metier.Client;
import metier.Compte;
import metier.Conseiller;

public interface IDao {
/**
 * Modifie un compte dans la base de données
 * @param compte Compte modifié
 * @return retourne le nombre de lignes modifiées dans la table
 */
 
	public int modifierCompte(Compte compte);
/**
 * methode qui creer un conseiller dans la base de données
 * @param conseiller conseiller a inserer dans la base de données
 * @return retourne le nombre de lignes modifiées dans la table
 */
 
	public int creerConseiller(Conseiller conseiller);
/**
 * Modifie un conseiller dans la base de données
 * @param conseiller conseiller modifié
 * @return retourne le nombre de lignes modifiées dans la base de données
 */
	public int modifierConseiller(Conseiller conseiller);
/**
 * Méthode qui verifie le login et le passWord d'un utilisateur dans la base de données
 * @param login identifiant
 * @param pwd	mots de passe
 * @return retourne le conseiller si trouver en base de données
 */
	public Conseiller verificationLogin(String login, String pwd);
/**
 * supprime un conseiller de la base de données
 * @param conseiller conseiller à supprimer
 * @return retourne le nombre de lignes modifiées dans la base de données
 */

	public int supprimerConseiller(Conseiller conseiller);
/**
 * creer un compte dans la base de données
 * @param compte compte à créer
 * @return retourne le nombre de lignes modifiées dans la base de données
 */
 
	public int creerCompte(Compte compte);
/**
 * retourne un compte selectionner par sont id
 * @param id identifiant du compte a retourner
 * @return compte correspondant à l'Id
 */
	public Compte getCompteParId(int id);
/**
 * supprime le compte de la base de données
 * @param compte compte à supprimer
 * @return retourne le nombre de lignes modifiées
 */
	public int supprimerCompte(Compte compte);
/**
 * creer un client dans la base de données
 * @param client client à creer
 * @return retourne le nombre de lignes modifiées
 */
	public int creerClient(Client client);
	
/**
 * modifie le client dans la base de données
 * @param client client a modifié
 * @return retourne le nombre de lignes modifiées
 */
	public int modifierClient(Client client);
/**
 * supprime un client dans la base de données
 * @param client client à supprimer
 * @return retourne le nombre de lignes modifiées dans la base de données
 */
	public int supprimerClient(Client client);
/**
 * Retourne un client correspondant a l'Id
 * @param idClient id du client à retourner
 * @return client correspondant à l'id
 */
	public Client retourneClientParId(int idClient);
	
	/**
	 * retourne la liste de clients d'un conseiller
	 * @param idConseiller  identifiant du conseiller dont on veux la liste de clients
	 * @return la liste de client du conseiller
	 */

	public Collection<Client> listerClientsParConseiller(int idConseiller);
	
	/**
	 * Récupère tous les comptes de l'agence
	 * @return une collection de compte
	 */
	public Collection<Compte> listerComptes();
	
	/**
	 * retourne le conseiller corespondant a l'Id
	 * @param idConseiller id du conseiller à retourner
	 * @return conseiller corespondant a l'Id
	 */
	public Conseiller afficherConseiller(int idConseiller);

}
