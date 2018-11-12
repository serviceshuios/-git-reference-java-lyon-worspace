package metier;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe CompteCourant permet de d�finir les comptes bancaires courants.
 * @author BERNY OTHMANE
 * @version v1.0
 */
@ManagedBean
@Entity
@DiscriminatorValue(value="CompteCourant")
public class CompteCourant extends Compte {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Le d�couvert autoris�.
	 */
	private double decouvert;

	/**
	 * Constructeur de la classe CompteCourant
	 */
	public CompteCourant() {
		super();
	}
	
	/**
	 * Constructeur de la classe CompteCourant
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public CompteCourant(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		super(idCompte, soldeCompte, dateOuvertureCompte);
	}
	
	/**
	 * Constructeur de la classe CompteCourant permettant de param�trer le d�couvert autoris�
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @param decouvert : le d�couvert autoris�
	 */
	public CompteCourant(int idCompte, double soldeCompte, Date dateOuvertureCompte, double decouvert) {
		super(idCompte, soldeCompte, dateOuvertureCompte);
		this.decouvert = decouvert;
	}

	/**
	 * Getter de l'attribut decouvert
	 * @return le d�couvert autoris� du compte
	 */
	public double getDecouvert() {
		return decouvert;
	}

	/**
	 * Setter de l'attribut decouvert
	 * @param decouvert : le d�couvert autoris� sur le compte
	 */
	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[ Compte Courant n° " + super.idCompte + " ] Solde = " + super.soldeCompte + ", | Date d'ouverture = " + super.dateOuvertureCompte;
	}
}
