package metier;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe du domaine metier: Gerant.
 * Le gerant herite directement de la classe conseiller et par la classe conseiller de la classe personne. 
 * Le gerant dispose de deux attributs qui lui sont propres: l'agence dans laquelle il travaille et la liste de conseillers 
 * sous ses ordres.
 * @author Eddy
 *
 */
public class Gerant extends Conseiller{
	
	// Proprietes
	private Agence agence;
	private Collection<Conseiller> listeConseillers;

	// Constructeur
	/**
	 * @param nom Le nom du gerant
	 * @param prenom Le prenom du gerant
	 * @param civilite La civilite du gerant
	 * @param agence L'agence dans laquelle le gerant exerce
	 */
	public Gerant(String nom, String prenom, String civilite, Agence agence) {
		super(nom, prenom, civilite);
		this.agence = agence;
		this.listeConseillers = new ArrayList<Conseiller>();
	}

	// Getters et Setters
	/**
	 * @return the agence
	 */
	public Agence getAgence() {
		return agence;
	}

	/**
	 * @param agence the agence to set
	 */
	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	/**
	 * @return the listeConseillers
	 */
	public Collection<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	/**
	 * @param listeConseillers the listeConseillers to set
	 */
	public void setListeConseillers(Collection<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}
}
