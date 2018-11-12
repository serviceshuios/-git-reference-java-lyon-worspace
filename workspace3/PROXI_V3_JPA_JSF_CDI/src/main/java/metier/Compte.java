package metier;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * La classe Compte permet de d�finir les comptes bancaires.
 * Classe abstraite n'ayant pas d'existence logique .
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypeCompte")
public abstract class Compte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Attribut static commun � toutes les instances de Compte
	 * permettant de comptabiliser le nombre de compte bancaires.
	 */
	private static int nbComptes;
	
	/**
	 * L'identifiant du compte.
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int idCompte;
	
	/**
	 * Le solde du compte
	 */
	@Column(columnDefinition="Decimal(10,2)")//bride à 2 décimales la BDD
	protected double soldeCompte;
	
	/**
	 * La date d'ouverture du compte
	 */
	protected Date dateOuvertureCompte;
	
	/**
	 * Le Client propri�taire du compte
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Client clientProprietaire;
	
	/**
	 * La carte associ�e au compte
	 */
	@Transient
	private CarteBancaire carteCompte;
	
	/**
	 * Constructeur de la classe Compte sans argument
	 */
	public Compte() {
		super();
		// incr�mentation du nombre de comptes
		setNbComptes(getNbComptes() + 1);
	}

	/**
	 * Constructeur de la classe Compte avec arguments
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public Compte(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		super();
		this.idCompte = idCompte;
		this.soldeCompte = soldeCompte;
		this.dateOuvertureCompte = dateOuvertureCompte;
		// incr�mentation du nombre de comptes
		setNbComptes(getNbComptes() + 1);
	}
	
	/**
	 * Getter de l'attribut static nbComptes
	 * @return le nombre de comptes
	 */
	public static int getNbComptes() {
		return nbComptes;
	}

	/**
	 * Setter de l'attribut static nbComptes
	 * @param nbComptes : le nombre de comptes
	 */
	public static void setNbComptes(int nbComptes) {
		Compte.nbComptes = nbComptes;
	}

	/**
	 * Getter de l'attribut de classe idCompte
	 * @return l'identifiant du compte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * Setter de l'attribut de classe idCompte
	 * @param idCompte : l'identifiant du compte
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * Getter de l'attribut de classe soldeCompte
	 * @return le solde du compte
	 */
	public double getSoldeCompte() {
		return soldeCompte;
	}

	/**
	 * Setter de l'attribut de classe soldeCompte
	 * @param soldeCompte : le solde du compte
	 */
	public void setSoldeCompte(double soldeCompte) {
		this.soldeCompte = soldeCompte;
	}

	/**
	 * Getter de l'attribut de classe dateOuvertureCompte
	 * @return la date d'ouverture du compte
	 */
	public Date getDateOuvertureCompte() {
		return dateOuvertureCompte;
	}

	/**
	 * Setter de l'attribut de classe dateOuvertureCompte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 */
	public void setDateOuvertureCompte(Date dateOuvertureCompte) {
		this.dateOuvertureCompte = dateOuvertureCompte;
	}

	
	/**
	 * Getter de l'attribut de classe clientProprietaire
	 * @return le Client propri�taire du compte
	 */
	public Client getClientProprietaire() {
		return clientProprietaire;
	}

	/**
	 * Getter de l'attribut de classe clientProprietaire
	 * @param clientProprietaire : le Client propri�taire du compte
	 */
	public void setClientProprietaire(Client clientProprietaire) {
		this.clientProprietaire = clientProprietaire;
	}
	
	/**
	 * Getter de l'attribut carteCompte
	 * @return la carte du compte
	 */
	public CarteBancaire getCarteCompte() {
		return carteCompte;
	}

	/**
	 * Setter de l'attribut carteCompte
	 * @param carteCompte : la carte du compte
	 */
	public void setCarteCompte(CarteBancaire carteCompte) {
		this.carteCompte = carteCompte;
	}
	
}
