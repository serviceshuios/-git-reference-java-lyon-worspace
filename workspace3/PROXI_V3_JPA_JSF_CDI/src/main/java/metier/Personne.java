package metier;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 * La classe Personne permet de d�finir une personne.
 * Classe abstraite.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@ManagedBean
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TypePersonne")
public abstract class Personne implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * id de la personne
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int id;
	
	/**
	 * La civilit� de la personne (M. Mme. Melle. etc...)
	 */
	protected String civilite;
	
	/**
	 * Le nom de la personne.
	 */
	protected String nom;
	
	/**
	 * Le pr�nom de la personne.
	 */
	protected String prenom;
	
	/**
	 * L'adresse de la personne
	 */
	@ManyToOne(cascade=CascadeType.PERSIST)
	protected Adresse adresse;
	
	/**
	 * Le num�ro de t�l�phone de la personne.
	 */
	protected String telephone;
	
	/**
	 * L'adresse mail de la personne.
	 */
	protected String email;

	/**
	 * Constructeur de la classe Personne sans arguments
	 */
	public Personne() {
		super();
	}

	/**
	 * Constructeur de la classe Personne avec arguments
	 * @param civilite civilite de la personne
	 * @param nom nom de la personne
	 * @param prenom pr�nom de la personne
	 */
	public Personne(String civilite, String nom, String prenom) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
	}
	
	/**
	 * Constructeur de la classe Personne avec arguments
	 * @param civilite civilite de la personne
	 * @param nom nom de la personne
	 * @param prenom pr�nom de la personne
	 * @param adresse adresse de la personne
	 * @param telephone t�l�phone de la personne
	 */
	public Personne(String civilite, String nom, String prenom, Adresse adresse, String telephone) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}

	/**
	 * Constructeur de la classe Personne avec arguments
	 * @param civilite civilite de la personne
	 * @param nom nom de la personne
	 * @param prenom pr�nom de la personne
	 * @param adresse adresse de la personne
	 * @param telephone t�l�phone de la personne
	 * @param email email de la personne
	 */
	public Personne(String civilite, String nom, String prenom, Adresse adresse, String telephone, String email) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter de l'attribut civilit�
	 * @return la civilit� de la personne
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * Setter de l'attribut civilite
	 * @param civilite : la civilit� de la personne
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	/**
	 * Getter de l'attribut nom
	 * @return le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter de l'attribut nom
	 * @param nom : le nom de la personne
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de l'attribut prenom
	 * @return le prenom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Setter de l'attribut prenom
	 * @param prenom : le prenom de la personne
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de l'attribut adresse
	 * @return l'adresse de la personne
	 */
	public Adresse getAdresse() {
		return this.adresse;
	}

	/**
	 * Setter de l'attribut adresse
	 * @param adresse : l'adresse de la personne
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	/**
	 * Getter de l'attribut telephone
	 * @return le t�l�phone de la personne
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Setter de l'attribut telephone
	 * @param telephone : le t�l�phone de la personne
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de l'attribut email
	 * @return l'adresse email de la personne
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de l'attribut email
	 * @param email : l'adresse email de la personne
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Personne [NOM = " + nom + ", PRENOM = " + prenom + ", ADRESSE = " + adresse + ", TELEPHONE = " + telephone + ", EMAIL = " + email + "]";
	}	

}
