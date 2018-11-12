package metier;

/**
 * Classe pour la gestion des donnees d'une personne. 
 * Les proprietes nom, prenom et civilite sont des varaibles String qui sont non visible a l'exterieur de la classe.
 * Il existe deux constructeurs. 
 * Le premier n'a aucun parametre, le deuxième prend en parametre nom, prenom et civilite.
 * Pour chaque propriete il existe des fonctions getter et setter.
 * Il existe egalement une methode toString() pour l'affichage des proprietes d'une personne.
 *  @author Eddy
 */

public abstract class Personne {

	// Attibuts
	private String nom;
	private String prenom;
	private String civilite;

	// Constructeurs
	/**
	 * Default constructor
	 */
	public Personne() {
		super();
	}
	/**
	 * @param nom Le nom de la personne
	 * @param prenom Le prenom de la personne
	 * @param civilite La civilite de la personne
	 */
	public Personne(String nom, String prenom, String civilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}
	
	// Getters et Setters
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the civilite
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * @param civilite the civilite to set
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return civilite + " " + prenom + " " + nom;
	}	
}
