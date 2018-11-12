package metier;

/**
 * Classe domaine metier: Carte bancaire. Definit les objets carte bancaire dont vont heriter des types de carte bancaires particuliers. Les proprietes sont le numero de CB, l'etat de la carte (bloquee ou non bloquee) et le compte associe a la CB.
 * @author Eddy
 *
 */
public abstract class CarteBancaire {

	// Proprietes
	private String numero;
	private boolean bloquee = false;
	
	// Constructeur
	
	/**
	 * @param numero Le numero de la carte bancaire (le numero imprime dessus)
	 * @param bloquee L'etat de la carte bancaire: si true alors la carte est bloquee et ne pourra pas debiter
	 */
	public CarteBancaire(String numero, boolean bloquee) {
		super();
		this.numero = numero;
		this.bloquee = bloquee;
	}

	/**
	 * Constructeur par default
	 */
	public CarteBancaire() {
		super();
	}

	// Getters et Setters
	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the bloquee
	 */
	public boolean isBloquee() {
		return bloquee;
	}

	/**
	 * @param bloquee the bloquee to set
	 */
	public void setBloquee(boolean bloquee) {
		this.bloquee = bloquee;
	}
	
	
	
}
