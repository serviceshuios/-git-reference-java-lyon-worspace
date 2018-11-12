package metier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe du domaine metier pour les conseillers. Les conseillers heritent de la classe personne. Ils heritent des attributs nom, prenom et civilite de la classe personne. 
 *  La classe conseiller a un attribut particulier: la liste de clients affilies au conseiller. 
 * @author Eddy
 *
 */
public class Conseiller extends Personne {

	// Propretes
	private Gerant gerant;
	private Collection<Client> listeClients;

	// Constructeur
	/**
	 * @param nom Le nom du conseiller
	 * @param prenom Le prenom du conseiller
	 * @param civilite La civilite du conseiller
	 */
	public Conseiller(String nom, String prenom, String civilite) {
		super(nom, prenom, civilite);
		this.listeClients = new ArrayList<Client>();
	}

	
	/**
	 * @param nom Le nom du conseiller
	 * @param prenom Le prenom du conseiller
	 * @param civilite La civilite du conseiller
	 * @param gerant Le gerant responsable du conseiller
	 */
	public Conseiller(String nom, String prenom, String civilite, Gerant gerant) {
		super(nom, prenom, civilite);
		this.gerant = gerant;
		this.listeClients = new ArrayList<Client>();
		this.gerant.getListeConseillers().add(this);
	}

	
	// Getters et Setters

	/**
	 * @return the gerant
	 */
	public Gerant getGerant() {
		return gerant;
	}


	/**
	 * @param gerant the gerant to set
	 */
	public void setGerant(Gerant gerant) {
		this.gerant = gerant;
	}

	/**
	 * @return the listeClients
	 */
	public Collection<Client> getListeClients() {
		return listeClients;
	}

	/**
	 * @param listeClients the listeClients to set
	 */
	public void setListeClients(Collection<Client> listeClients) {
		this.listeClients = listeClients;
	}	
}
