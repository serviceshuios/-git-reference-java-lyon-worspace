package org.v3.service.exceptions;

/** 
 * La classe SoldeInsuffisantException permet de g�rer les erreurs li�es aux op�rations sur un compte bancaire d�biteur
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class SoldeInsuffisantException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public SoldeInsuffisantException(String message) {
		/**
		 * Appel du constructeur de la classe Exception � qui on passe le message d'erreur
		 */
		super(message);
	}
	
}