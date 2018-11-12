package org.v3.service.exceptions;

/** 
 * La classe NombreMaxClientsParConseillerException permet de g�rer le cas o�
 * un conseiller client�le tente d'ajouter un client alors qu'il en g�re d�j� 10
 * Cette limite est une demande de ProxiBanque 
 * @author BERNY OTHMANE
 * @version 1.0
 */
public class NombreMaxClientsParConseillerException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public NombreMaxClientsParConseillerException(String message) {
		/**
		 * Appel du constructeur de la classe Exception � qui on passe le message d'erreur
		 */
		super(message);
	}
	
}