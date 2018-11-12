package metier;

import java.util.Date;

/**
 * Classe pour la gestion d'un compte d'epargne, heritant de Compte.
 * Un plus des proprietes heritees numero, solde, dateOuverture et compteEntreprise, 
 * il existe le titulaire et le taux d'interêt. Le seul constructeur prend en parametre un String pour numero,
 * un float pour solde, une Date pour dateOuverture, un boolean pour compteEntreprise et un Client pour titulaire. 
 * Le taux d'interêt est une constante fixee a 3 pour cent par an.
 * Il existe des methodes getters et setters pour chaque propriete sauf TAUX.
 *
 */

public class CompteEpargne extends Compte {
	
	private Client titulaire;
	private final float TAUX;
	
	// Constructeur

	/**
	 * @param numero Le numero associe au compte
	 * @param solde Le solde du compte
	 * @param dateOuverture La date d'ouverture du compte
	 * @param compteEntreprise True si le compte correspond a un compte entreprise
	 * @param titulaire Le titulaire du compte
	 */
	public CompteEpargne(String numero, float solde, Date dateOuverture, boolean compteEntreprise, Client titulaire) {
		super(numero, solde, dateOuverture, compteEntreprise);
		this.titulaire = titulaire;
		this.TAUX = 0.03f;
	}

	// Getters et setters liees a la clase COmpteEpargne.
	/**
	 * @return the taux
	 */
	public float getTAUX() {
		return TAUX;
	}

	/**
	 * @return the titulaire
	 */
	public Client getTitulaire() {
		return titulaire;
	}

	/**
	 * @param titulaire the titulaire to set
	 */
	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
}
