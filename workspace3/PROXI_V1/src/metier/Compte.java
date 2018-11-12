package metier;

import java.util.Date;

/**
 * Classe pour la gestion des comptes bancaires.
 * Les proprietes sont le numero du compte, le solde, la date d'ouverture, 
 * et un boolean qui indique si le compte est associe a une entreprise, ce qui a un effet sur le decouvert autorise.
 * Le constructeur prend en parametre un String pour le numero du compte, un float pour le solde,
 * une Date pour la date d'ouverture, et un boolean pour compteEntreprise.
 * Il existe des methodes getters et setters pour chacun des proprietes. 
 * @author Eddy
 */

public abstract class Compte {
	
	// Proprietes de la classe
	private String numero;
	private float solde;
	private Date dateOuverture;
	private boolean compteEntreprise = false;
	
	// Constructeur
	/**
	 * @param numero Le numero associe au compte bancaire
	 * @param solde Le solde du compte bancaire
	 * @param dateOuverture La date d'ouverture du Compte
	 * @param compteEntreprise Boleen statu du compte: true si le compte est un compte entreprise
	 */
	public Compte(String numero, float solde, Date dateOuverture, boolean compteEntreprise) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.compteEntreprise = compteEntreprise;
	}
		
	/**
	 * Constructeur par default
	 */
	public Compte() {
		super();
	}


	//Getters et setters de la classe Compte. Permet d'obtenir les infos liees au compte
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return the solde
	 */
	public float getSolde() {
		return solde;
	}
	/**
	 * @param solde the solde to set
	 */
	public void setSolde(float solde) {
		this.solde = solde;
	}
	/**
	 * @return the dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * @param dateOuverture the dateOuverture to set
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/**
	 * @return the compteEntreprise
	 */
	public boolean isCompteEntreprise() {
		return compteEntreprise;
	}
	/**
	 * @param compteEntreprise the compteEntreprise to set
	 */
	public void setCompteEntreprise(boolean compteEntreprise) {
		this.compteEntreprise = compteEntreprise;
	}

	/**
	 * @return affichage du compte
	 */
	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", solde=" + solde + ", dateOuverture=" + dateOuverture
				+ ", compteEntreprise=" + compteEntreprise + "]";
	}
	
	
}
