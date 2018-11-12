package metier;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe ClientParticulier permet de d�finir un client particulier
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@ManagedBean
@Entity
@DiscriminatorValue(value="ClientParticulier")
public class ClientParticulier extends Client {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1776652035899750426L;

	/**
	 * Constructeur de la classe ClientParticulier
	 */
	public ClientParticulier() {
		super();
	}
	
	/**
	 * Constructeur de la classe ClientParticulier
	 * @param idClient : l'identifiant du client
	 * @param civilite : la civilit� du client
	 * @param nomClient : le nom du client
	 * @param prenomClient : le pr�nom du client
	 * @param adresseClient : l'adrese du client
	 * @param telephoneClient : le telephone du client
	 * @param emailClient : l'adresse email du client
	 */
	public ClientParticulier(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient) {
		super(idClient, civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient);
	}
	
	public String toString(){
		return "Client n " + id + " : " + getCivilite() + " " + getPrenom() + " " + getNom();
	}
	
}
