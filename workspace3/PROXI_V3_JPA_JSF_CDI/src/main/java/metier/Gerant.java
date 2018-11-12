package metier;

/**
 * La classe Gerant permet de d�finir un g�rant
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class Gerant extends Personne {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2573130122336303762L;

	/**
	 * L'identifiant du g�rant.
	 */
	private int idGerant;
	
	/**
	 * L'agence du g�rant.
	 */
	private Agence agence;

	/**
	 * Constructeur de la classe Gerant avec arguments
	 * @param idGerant : l'identification du g�rant
	 * @param civiliteGerant : la civilit� du g�rant
	 * @param nom : le nom du g�rant
	 * @param prenom : le prenom du g�rant
	 */
	public Gerant(int idGerant, String civiliteGerant, String nomGerant, String prenomGerant) {
		super(civiliteGerant, nomGerant, prenomGerant);
		this.idGerant = idGerant;
	}

	/**
	 * Getter de l'attribut IdGerant
	 * @return l'identifiant du g�rant
	 */
	public int getIdGerant() {
		return idGerant;
	}

	/**
	 * Setter de l'attribut IdGerant
	 * @param idGerant : l'identifiant du g�rant
	 */
	public void setIdGerant(int idGerant) {
		this.idGerant = idGerant;
	}

	/**
	 * Getter de l'attribut monAgence
	 * @return le nom de l'agence � laquelle est affect� le g�rant
	 */
	public Agence getAgence() {
		return this.agence;
	}

	/**
	 * Setter de l'attribut monAgence
	 * @param agence : le nom de l'agence � laquelle est affect� le g�rant
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Gerant n� " + idGerant + " : " + getCivilite() + " " + getPrenom() + " " + getNom();
	}

}
