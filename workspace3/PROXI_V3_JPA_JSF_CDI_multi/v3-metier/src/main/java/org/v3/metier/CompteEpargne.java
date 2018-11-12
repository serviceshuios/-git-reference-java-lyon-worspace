package org.v3.metier;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe CompteEpargne permet de d�finir les comptes bancaires d'�pargne.
 * @author BERNY OTHMANE
 * @version v1.0
 */
@ManagedBean
@Entity
@DiscriminatorValue(value="CompteEpargne")
public class CompteEpargne extends Compte {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Le taux de r�mun�ration du compte �pargne
	 */
	private float tauxRemuneration;

	/**
	 * Constructeur de la classe CompteEpargne
	 */
	public CompteEpargne() {
		super();
	}
	
	/**
	 * Constructeur de la classe CompteEpargne
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public CompteEpargne(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		super(idCompte, soldeCompte, dateOuvertureCompte);
	}

	/**
	 * Constructeur de la classe CompteEpargne permettant de param�trer le taux de r�mun�ration
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @param tauxRemuneration : le taux de r�mun�ration associ� au compte
	 */
	public CompteEpargne(int idCompte, double soldeCompte, Date dateOuvertureCompte, float tauxRemuneration) {
		super(idCompte, soldeCompte, dateOuvertureCompte);
		this.tauxRemuneration = tauxRemuneration;
	}

	/**
	 * Getter de l'attribut tauxRemuneration
	 * @return le taux de r�mun�ration associ� au compte
	 */
	public float getTauxRemuneration() {
		return tauxRemuneration;
	}

	/**
	 * Setter de l'attribut tauxRemuneration
	 * @param tauxRemuneration : le taux de r�mun�ration associ� au compte
	 */
	public void setTauxRemuneration(float tauxRemuneration) {
		this.tauxRemuneration = tauxRemuneration;
	}
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[ Compte Epargne n° " + super.idCompte + " ] Solde = " + super.soldeCompte + ", | Date d'ouverture = " + super.dateOuvertureCompte;
	}
}
