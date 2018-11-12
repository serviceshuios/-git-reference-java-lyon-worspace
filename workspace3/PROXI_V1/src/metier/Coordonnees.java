/**
 * 
 */
package metier;

/**
 * Classe pour la gestion des adresses et des numeros de telephone.
 * Les proprietes adresse, ville, cp (pour code postal) et telephone sont des varaibles String 
 * qui sont cachees a l'exterieur de la classe.
 * Il existe un seul constructeurs qui prend en parametre l'adresse, la ville, le code postal, 
 * et le numero de telephone, tous en String.
 * Pour chaque propriete il existe des methodes getter et setter.
 *@author Eddy
 */

public class Coordonnees {
	
	// Proprietes
	private String adresse;
	private String ville;
	private String cp;
	private String telephone;
	
	// Constructeurs
	/**
	 * @param adresse Detail de l'adresse
	 * @param ville La ville
	 * @param cp Le code postal associe a la ville
	 * @param telephone Le telephone
	 */
	public Coordonnees(String adresse, String ville, String cp, String telephone) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.cp = cp;
		this.telephone = telephone;
	}

	// Getters et Setters
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	// Methode toString()
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Coordonees: " + adresse + ", " + cp + " " + ville + "; tel: " + telephone;
	}	
}
