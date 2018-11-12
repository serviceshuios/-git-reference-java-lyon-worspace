package metier;

import java.util.Date;

/**
 * La classe carteVisaElectron permet de d�finir une carte visa electron.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
public class CarteVisaElectron extends CarteBancaire {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** Constructeur de la classe CarteVisaElectron avec arguments
	 * @param numeroCarte num�ro de la carte
	 * @param dateExpiration date d'expiration de la carte
	 * @param codeSecurite code de s�curit� de la carte
	 */
	public CarteVisaElectron(int numeroCarte, Date dateExpiration, String codeSecurite) {
		super(numeroCarte, dateExpiration, codeSecurite);
	}

}
