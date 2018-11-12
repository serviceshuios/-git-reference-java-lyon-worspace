package metier;

/**
 * La classe creditConsommation permet de d�finir un cr�dit � la consommation.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class CreditConsommation extends Credit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe CreditConsommation avec arguments
	 * @param taux taux du cr�dit
	 * @param duree dur�e du cr�dit
	 * @param montant montant du cr�dit
	 */
	public CreditConsommation(float taux, int duree, double montant) {
		super(taux, duree, montant);
	}

}
