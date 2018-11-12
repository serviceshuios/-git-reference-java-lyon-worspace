package metier;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe ClientEntreprise permet de d�finir un client de type entreprise
 * 
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@ManagedBean
@Entity
@DiscriminatorValue(value="ClientEntreprise")
public class ClientEntreprise extends Client {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5034344183472550451L;

	/**
	 * Constructeur de la classe ClientEntreprise
	 */
	public ClientEntreprise() {
		super();
	}

	/**
	 * Constructeur de la classe ClientEntreprise
	 * 
	 * @param idClient
	 *            : l'identifiant du client
	 * @param civilite
	 *            : la civilit� du client
	 * @param nomClient
	 *            : le nom du client
	 * @param prenomClient
	 *            : le pr�nom du client
	 * @param adresseClient
	 *            : l'adrese du client
	 * @param telephoneClient
	 *            : le telephone du client
	 * @param emailClient
	 *            : l'adresse email du client
	 * @param nomEntreprise
	 *            : le nom de l'entreprise du client
	 */
	public ClientEntreprise(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient,
			String telephoneClient, String emailClient, String nomEntreprise) {
		super(idClient, civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient);
		this.nomEntreprise = nomEntreprise;

	}
	
	public String toString(){
		return "Client n " + id + " : " + getCivilite() + " " + getPrenom() + " " + getNom() + " | Entreprise " + nomEntreprise;
	}

}
