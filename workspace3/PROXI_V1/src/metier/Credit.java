package metier;

/**
 * Classe du domaine metier: Credit. Cette classe regroupe l'ensemble des elements communs aux credits existant. Ses proprietees sont:
 * Le client concerne par le credit, le montant du credit, la duree du credit, le taux d'interet, la valeur d'amortissement mensuel
 * @author Eddy
 *
 */
public class Credit {
	
	// Proprietes
	private Client client;
	private float montant;
	private float duree;	// Duree du credit en annees
	private float taux;		// Taux d'interet par an
	private float amortissementMensuel;
	
	// Constructeurs
	/**
	 * Constructeur par defaut
	 */
	public Credit() {
		super();
	}

	/**
	 * @param client Le client concerne par le credit
	 * @param montant Le montant du credit
	 * @param duree La duree du credit
	 * @param taux Le taux d'interets 
	 * @param amortissementMensuel L'amortissement mensuel
	 */
	public Credit(Client client, float montant, float duree, float taux, float amortissementMensuel) {
		super();
		this.client = client;
		this.montant = montant;
		this.duree = duree;
		this.taux = taux;
		this.amortissementMensuel = amortissementMensuel;
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
	 * @return the duree
	 */
	public float getDuree() {
		return duree;
	}

	/**
	 * @param duree the duree to set
	 */
	public void setDuree(float duree) {
		this.duree = duree;
	}

	/**
	 * @return the taux
	 */
	public float getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(float taux) {
		this.taux = taux;
	}

	/**
	 * @return the amortissementMensuel
	 */
	public float getAmortissementMensuel() {
		return amortissementMensuel;
	}

	/**
	 * @param amortissementMensuel the amortissementMensuel to set
	 */
	public void setAmortissementMensuel(float amortissementMensuel) {
		this.amortissementMensuel = amortissementMensuel;
	}
}
