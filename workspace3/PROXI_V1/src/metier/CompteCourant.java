package metier;

import java.util.Date;

/**
 * Classe compte courant, cette classe herite d ela classe Compte. 
 * Le compte courant est un compte particulier. On y ajoute un attribut titulaire.
 * @author Eddy
 *
 */
public class CompteCourant extends Compte {
	
	// Proprietes
	private Client titulaire;
	private VisaElectron carteVisaElectron = null;
	private VisaPremier carteVisaPremier = null;
	private float valeurDecouvert = -1000;

	// Constructeur
	/**
	 * @param numero Le numero associe au compte courant
	 * @param solde Le solde du compte
	 * @param dateOuverture La date d'ouverture du compte
	 * @param compteEntreprise True si le compte est un compte entreprise
	 * @param titulaire Le client titulaire du compte 
	 */
	public CompteCourant(String numero, float solde, Date dateOuverture, boolean compteEntreprise, Client titulaire) {
		super(numero, solde, dateOuverture, compteEntreprise);
		this.titulaire = titulaire;
		
	}

	// Getters et Setters
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

	/**
	 * @return the carteVisaElectron
	 */
	public VisaElectron getCarteVisaElectron() {
		return carteVisaElectron;
	}

	/**
	 * @param carteVisaElectron the carteVisaElectron to set
	 */
	public void setCarteVisaElectron(VisaElectron carteVisaElectron) {
		this.carteVisaElectron = carteVisaElectron;
	}

	/**
	 * @return the carteVisaPremier
	 */
	public VisaPremier getCarteVisaPremier() {
		return carteVisaPremier;
	}

	/**
	 * @param carteVisaPremier the carteVisaPremier to set
	 */
	public void setCarteVisaPremier(VisaPremier carteVisaPremier) {
		this.carteVisaPremier = carteVisaPremier;
	}

	/**
	 * @return the valeurDecouvert
	 */
	public float getValeurDecouvert() {
		return valeurDecouvert;
	}

	/**
	 * @param valeurDecouvert the valeurDecouvert to set
	 */
	public void setValeurDecouvert(float valeurDecouvert) {
		this.valeurDecouvert = valeurDecouvert;
	}
	
}
