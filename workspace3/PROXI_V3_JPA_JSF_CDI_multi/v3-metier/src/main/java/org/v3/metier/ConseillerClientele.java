package org.v3.metier;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

import javax.faces.bean.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Classe ConseillerClientele servant � d�finir les conseillers client�le des agences bancaires
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@ManagedBean
@Entity
@DiscriminatorValue(value="ConseillerClientele")
public class ConseillerClientele extends Personne {

//	/**
//	 * L'identifiant du conseiller
//	 */
//	private int idConseiller;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Le password d'authentification du conseiller
	 */
	private String password;
	
	/**
	 * L'agence � laquelle est affect�e le conseiller
	 */
	@Transient //non persisté pour le moment
	private Agence monAgence;
	
	/**
	 * Le g�rant responsable du conseiller client�le
	 */
	@Transient //non persisté pour le moment
	private Gerant monGerant;
	
	/**
	 * Les clients affect�s � un conseiller client�le
	 */
	@OneToMany(fetch = FetchType.EAGER , mappedBy="monConseiller")
	private Collection<Client> mesClients = new ArrayList<Client>();
	
	
	public ConseillerClientele() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructeur de la classe ConseillerClientele avec arguments
	 * @param idConseiller : l'identifiant du conseiller client�le
	 * @param civiliteConseiller : la civilit� du conseiller client�le
	 * @param nomConseiller : le nom du conseiller client�le
	 * @param prenomConseiller : le prenom du conseiller client�le
	 */
	public ConseillerClientele(int idConseiller, String civiliteConseiller, String nomConseiller, String prenomConseiller) {
		super(civiliteConseiller, nomConseiller, prenomConseiller);
		//this.idConseiller = idConseiller;
		
		// Initialisation de la collection de clients du conseillers client�le
		this.mesClients = new TreeSet<Client>(
				new Comparator<Client>() {
					
					@Override
					//public int compare(Client c1, Client c2) {				// tri des clients selon l'ordre alphab�tique 
					//	if (c1.getNom().equals(c2.getNom())) {					// si les 2 noms sont �gaux
					//		return c1.getPrenom().compareTo(c2.getPrenom());	// comparer les pr�noms
					//	} else {												// sinon
					//		return c1.getNom().compareTo(c2.getNom());			// comparer les noms
					//		
					//	}
					//}
					
					public int compare(Client c1, Client c2) {					// tri des clients selon l'identifiant 
						return ((Integer)c1.getId()).compareTo(c2.getId());
					}
			}
		);
	}

//	/**
//	 * Getter de l'attribut de classe idConseiller
//	 * @return l'identifiant du conseiller
//	 */
//	public int getIdConseiller() {
//		return this.idConseiller;
//	}
//
//	/**
//	 * Setter de l'attribut de classe idConseiller
//	 * @param idConseiller : l'identifiant du conseiller
//	 */
//	public void setIdConseiller(int idConseiller) {
//		this.idConseiller = idConseiller;
//	}

	/**
	 * Getter de l'attribut de classe password
	 * @return le mot de passe du conseiller
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter de l'attribut de classe password
	 * @param password : le mot de passe du conseiller
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Getter de l'attribut de classe monAgence
	 * @return l'agence � laquelle est affect� le conseiller client�le
	 */
	public Agence getMonAgence() {
		return this.monAgence;
	}

	/**
	 * Setter de l'attribut de classe monAgence
	 * @param monAgence : l'agence � laquelle est affect� le conseiller client�le
	 */
	public void setMonAgence(Agence monAgence) {
		this.monAgence = monAgence;
	}
	
	/**
	 * Getter de l'attribut de classe monGerant
	 * @return le g�rant responsable du conseiller client�le
	 */
	public Gerant getMonGerant() {
		return this.monGerant;
	}

	/**
	 * Setter de l'attribut de classe monGerant
	 * @param monGerant : le g�rant responsable du conseiller client�le
	 */
	public void setMonGerant(Gerant monGerant) {
		this.monGerant = monGerant;
	}

	/**
	 * Getter de l'attribut de classe mesClients
	 * @return les clients g�r�s par le conseiller client�le
	 */
	public Collection<Client> getMesClients() {
		return mesClients;
	}

	/**
	 * Setter de l'attribut de classe mesClients
	 * @param mesClients : les clients g�r�s par le conseiller client�le
	 */
	public void setMesClients(Collection<Client> mesClients) {
		this.mesClients = mesClients;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Conseiller Clientele n " + id + " : " + getCivilite() + " " + getPrenom() + " " + getNom();
	}
	
}
