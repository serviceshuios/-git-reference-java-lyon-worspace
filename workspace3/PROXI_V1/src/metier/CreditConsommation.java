package metier;

/**
 * Classe metier de Credit consommatoion: cette classe herite de la classe credit.
 * @author Eddy
 *
 */
public class CreditConsommation extends Credit {
	
	/**
	 * @param client Le client concerne par le credit
	 * @param montant Le montant du credit
	 * @param duree La duree du credit
	 * @param taux Le taux d'interets 
	 * @param amortissementMensuel L'amortissement mensuel
	 */
	public CreditConsommation(Client client, float montant, float duree, float taux, float amortissementMensuel) {
		super(client, montant, duree, taux, amortissementMensuel);
	}

}
