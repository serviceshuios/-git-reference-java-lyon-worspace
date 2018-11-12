package org.v3.metier;

import java.io.Serializable;
import java.util.Date;

/**
 * La classe CarteBancaire permet de d�finir une carte bancaire
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class CarteBancaire implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3410111823464422979L;

	/**
	 * Le num�ro de la carte.
	 */
	private int numeroCarte;
	
	/**
	 * La date d'expiration de la carte.
	 */
	private Date dateExpiration;
	
	/**
	 * Le code de s�curit� de la carte.
	 */
	private String codeSecurite;
	
	/**
	 * Le nom du propri�taire de la carte.
	 */
	private String nomCarte;
	
	/**
	 * Le pr�nom du propri�taire de la carte.
	 */
	private String prenomCarte;
	

	/** Constructeur de la classe Carte avec arguments
	 * @param numeroCarte num�ro de la carte
	 * @param dateExpiration date d'expiration de la carte
	 * @param codeSecurite code de s�curit� de la carte
	 */
	public CarteBancaire(int numeroCarte, Date dateExpiration, String codeSecurite) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateExpiration = dateExpiration;
		this.codeSecurite = codeSecurite;
	}

	/**
	 * Getter de l'attribut numeroCarte
	 * @return numeroCarte : le num�ro de carte
	 */
	public int getNumeroCarte() {
		return numeroCarte;
	}

	/**
	 * Setter de l'attribut numeroCarte
	 * @param numeroCarte : le num�ro de carte
	 */
	public void setNumeroCarte(int numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	/**
	 * Getter de l'attribut dateExpiration
	 * @return la date d'expiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * Setter de l'attribut dateExpiration
	 * @param dateExpiration : la date d'expiration
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * Getter de l'attribut codeSecurite
	 * @return le code de s�curit�
	 */
	public String getCodeSecurite() {
		return codeSecurite;
	}

	/**
	 * Setter de l'attribut codeSecurite
	 * @param codeSecurite : le code de s�curit�
	 */
	public void setCodeSecurite(String codeSecurite) {
		this.codeSecurite = codeSecurite;
	}

	/**
	 * Getter de l'attribut nomCarte
	 * @return le nom du propri�taire de la carte
	 */
	public String getNomCarte() {
		return nomCarte;
	}

	/**
	 * Setter de l'attribut nomCarte
	 * @param nomCarte : le pnom du propri�taire de la carte
	 */
	public void setNomCarte(String nomCarte) {
		this.nomCarte = nomCarte;
	}

	/**
	 * Getter de l'attribut prenomCarte
	 * @return le pr�nom du propri�taire de la carte
	 */
	public String getPrenomCarte() {
		return prenomCarte;
	}

	/**
	 * Setter de l'attribut prenomCarte
	 * @param prenomCarte le pr�nom du propri�taire de la carte
	 */
	public void setPrenomCarte(String prenomCarte) {
		this.prenomCarte = prenomCarte;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CarteBancaire [numeroCarte=" + numeroCarte + ", dateExpiration=" + dateExpiration + ", codeSecurite="
				+ codeSecurite + ", nomCarte=" + nomCarte + ", prenomCarte=" + prenomCarte + "]";
	}

}
