package metier;

/**
 * Classe domaine metier: Carte Bancaire Visa Premier
 * Cette classe hérite de la classe carte bancaire. Elle possede en plus un titulaire.
 * Cette classe regroupe l'ensembles des proprietes liees aux cartes VisaPremier. 
 * Pour ajouter une carte a un client on va construire un objet de cette classe
 * @author Eddy
 *
 */
public class VisaPremier extends CarteBancaire {

	// Proprietes
	private CompteCourant compteAssocie;

	// Constructeur
	/**
	 * @param numero Le numero de la carte
	 * @param bloquee L'etat de la carte: true si la carte est bloquee
	 * @param compteAssocie Le compte associe a la carte bancaire.
	 */
	public VisaPremier(String numero, boolean bloquee, CompteCourant compteAssocie) {
		super(numero, bloquee);
		this.compteAssocie = compteAssocie;
	}

	// Getters et Setters
	/**
	 * @return the compteAssocie
	 */
	public CompteCourant getCompteAssocie() {
		return compteAssocie;
	}

	/**
	 * @param compteAssocie
	 *            the compteAssocie to set
	 */
	public void setCompteAssocie(CompteCourant compteAssocie) {
		this.compteAssocie = compteAssocie;
	}
}
