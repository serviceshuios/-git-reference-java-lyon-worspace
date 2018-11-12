package service.exceptions;

/**
 * Exception levée si lorsqu'un compte n'est pas éligible
 * @author Pierre
 *
 */
 public class CompteInvalideException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 * @param message
	 */
	public CompteInvalideException(String message) {

		super(message);
	}
	
}