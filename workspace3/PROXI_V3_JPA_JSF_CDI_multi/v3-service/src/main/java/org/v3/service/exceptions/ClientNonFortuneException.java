package org.v3.service.exceptions;

/** 
 * La classe ClientNonFortuneException permet de g�rer le cas o�
 * un conseiller client�le tente de faire un placement pour un client
 * dont le patrimoine est insuffisant (inf�rieur ou �gal � 500.000 �).
 *  
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class ClientNonFortuneException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public ClientNonFortuneException(String message) {
		/**
		 * Appel du constructeur de la classe Exception � qui on passe le message d'erreur
		 */
		super(message);
	}
	
}