package metier;

import java.io.Serializable;

/**
 * La classe Credit permet de d�finir un cr�dit
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public abstract class Credit implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Le taux du cr�dit en %.
	 */
	private float taux;
	
	/**
	 * La dur�e du cr�dit en mois.
	 */
	private int duree;
	
	/**
	 * Le montant du credit.
	 */
	private double montant;

	/**
	 * Constructeur de la classe Credit avec arguments
	 * @param taux : le taux du cr�dit
	 * @param duree : la dur�e du cr�dit
	 * @param montant : le montant du cr�dit
	 */
	public Credit(float taux, int duree, double montant) {
		super();
		this.taux = taux;
		this.duree = duree;
		this.montant = montant;
	}

	/**
	 * Getter de l'attribut taux
	 * @return le taux du cr�dit
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * Setter de l'attribut taux
	 * @param taux : le taux du cr�dit
	 */
	public void setTaux(float taux) {
		this.taux = taux;
	}

	/**
	 * Getter de l'attribut duree
	 * @return la dur�e du cr�dit
	 */
	public int getDuree() {
		return duree;
	}

	/**
	 * Setter de l'attribut duree
	 * @param duree la dur�e du cr�dit
	 */
	public void setDuree(int duree) {
		this.duree = duree;
	}

	/**
	 * Getter de l'attribut montant
	 * @return le montant du cr�dit
	 */
	public double getMontant() {
		return montant;
	}

	/**
	 * Setter de l'attribut montant
	 * @param montant le montant du cr�dit
	 */
	public void setMontant(double montant) {
		this.montant = montant;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Credit [taux=" + taux + ", duree=" + duree + ", montant=" + montant + "]";
	}

}
