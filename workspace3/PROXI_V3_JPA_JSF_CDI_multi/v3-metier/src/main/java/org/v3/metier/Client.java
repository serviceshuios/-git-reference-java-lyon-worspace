package org.v3.metier;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Classe Client permettant de d�finir les clients 
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@ManagedBean
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Client extends Personne implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	/**
//	 * L'identifiant du client.
//	 */
//	protected int idClient;

	/**
	 * Le nom de l'entreprise (le cas �ch�ant)
	 */
	protected String nomEntreprise;
	
	/**
	 * Les comptes du client
	 */
	//cascade ALL car la suppression d'un client entraine la suppression de ses comptes
	@OneToMany(fetch = FetchType.EAGER , mappedBy="clientProprietaire" , cascade=CascadeType.ALL)
	protected Collection<Compte> mesComptes = new ArrayList<Compte>();
	
	@ManyToOne
	protected ConseillerClientele monConseiller;
	
	/**
	 * Les cartes du client.
	 */
	@Transient //pas de carte en bdd pour le moment
	protected Collection<CarteBancaire> mesCartes;
	
	/**
	 * Les placements du client
	 */
	//private List<Placement> listePlacement;
	
	/**
	 * Constructeur de la classe Client
	 */
	public Client() {
		super();
	}
	
	/** Constructeur de la classe Client avec arguments
	 * @param idClient : l'identifiant du client
	 * @param civilite : la civilit� du client
	 * @param nomClient : le nom du client
	 * @param prenomClient : le prenom du client
	 * @param adresseClient : l'adresse du client
	 * @param telephoneClient : le telephone du client
	 * @param emailClient : l'adresse email du client
	 */
	public Client(int idClient, String civilite, String nomClient, String prenomClient, Adresse adresseClient, String telephoneClient, String emailClient) {
		super(civilite, nomClient, prenomClient, adresseClient, telephoneClient, emailClient);
//		this.idClient = idClient;
		//this.compteCourant = new CompteCourant();
		//this.compteEpargne = new CompteEpargne();
		//this.compteCourant = null;
		//this.compteEpargne = null;
		//this.listePlacement = new ArrayList<Placement>();
	}
	
	
//	/**
//	 * Getter de l'attribut idClient
//	 * @return l'identifiant du client
//	 */
//	public int getIdClient() {
//		return idClient;
//	}
//
//	/**
//	 * Setter de l'attribut idClient
//	 * @param idClient : l'identifiant du client
//	 */
//	public void setIdClient(int idClient) {
//		this.idClient = idClient;
//	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	/**
	 * Getter de l'attribut mesCartes
	 * @return les cartes du client
	 */
	public Collection<CarteBancaire> getMesCartes() {
		return mesCartes;
	}

	/**
	 * Setter de l'attribut mesCartes
	 * @param mesCartes : les cartes du client
	 */
	public void setMesCartes(Collection<CarteBancaire> mesCartes) {
		this.mesCartes = mesCartes;
	}


	public Collection<Compte> getMesComptes() {
		return mesComptes;
	}

	public void setMesComptes(Collection<Compte> mesComptes) {
		this.mesComptes = mesComptes;
	}

	public ConseillerClientele getMonConseiller() {
		return monConseiller;
	}

	public void setMonConseiller(ConseillerClientele monConseiller) {
		this.monConseiller = monConseiller;
	}
	
	

	
}
