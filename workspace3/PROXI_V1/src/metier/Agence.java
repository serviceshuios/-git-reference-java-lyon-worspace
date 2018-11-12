package metier;

import java.util.Date;

/**
 * Classe pour la gestion d'une agence au sein du système ProxiBanqueSI.
 * Elle a comme propriete id, un identifiant compose de 5 charactères alphanumerique, la date de sa creation, 
 * ses coordnonees, fournis par la classe Coordonees, et le gerant.
 * Il existe un constructeur qui prend en parametre l'id et la date de construction, 
 * et un autre aui prend en plus les coordonnees.
 * Il n'existe pas de methode setter pour id, parce que l'identifiant ne change pas une fois l'agence est cree.  
 * Il existe des methodes getters et setters pour toutes les autres parametres ainsi qu'une methode toString().
 *@author Eddy
 */

public class Agence {
	
	// Proprietes
	private String id;
	private Date dateCreation;
	private Coordonnees contact;
	private Gerant gerant;
	
	// Constructeurs
	/**
	 * @param id Identifiant de l'agence
	 * @param dateCreation Date de creation
	 */
	public Agence(String id, Date dateCreation) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
	}

	/**
	 * @param id Identifiant de l'agence
	 * @param dateCreation	Date de creation
	 * @param contact Coordnonees de contact
	 */
	public Agence(String id, Date dateCreation, Coordonnees contact) {
		super();
		this.id = id;
		this.dateCreation = dateCreation;
		this.contact = contact;
	}

	// Getters et setters de la classe
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the dateCreation
	 */
	public Date getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * @return the contact
	 */
	public Coordonnees getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(Coordonnees contact) {
		this.contact = contact;
	}
	
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

	// Methode toString()
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agence " + id + "; date de creation : " + dateCreation.toString() + "; " + contact.toString();
	}
}
