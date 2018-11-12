package metier;

/**
 * Classe domaine metier: placement. Cette classe comprend l'ensemble des donnes relative a un placement. Cette classe est 
 * instanciee lorsqu'un placement est fait au nom d'un client
 * Le placement possede trois proprietes: Le client pour qui a ete fait le placement, le montant du placement et la Place 
 * financiere a laquelle est lie le placement
 * @author Eddy
 *
 */
public class Placement {
	
	// Proprietes
	private Client client;
	private float montant;
	private String placeFinanciere;
	
	// Constructeur
	/**
	 * @param client Le client associe au placement
	 * @param montant Le montant du placement
	 * @param placeFinanciere La place financiere a laquelle on a fait le placement.
	 */
	public Placement(Client client, float montant, String placeFinanciere) {
		super();
		this.client = client;
		this.montant = montant;
		this.placeFinanciere = placeFinanciere;
	}

	// Getters et Setters
	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the montant
	 */
	public float getMontant() {
		return montant;
	}

	/**
	 * @param montant the montant to set
	 */
	public void setMontant(float montant) {
		this.montant = montant;
	}

	/**
	 * @return the placeFinancier
	 */
	public String getPlaceFinanciere() {
		return placeFinanciere;
	}

	/**
	 * @param placeFinanciere the placeFinancier to set
	 */
	public void setPlaceFinanciere(String placeFinanciere) {
		this.placeFinanciere = placeFinanciere;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return montant + " Euros ont été investis à " + placeFinanciere + " pour " + client + ".";
	}
}
