package blazon.shared.shield.tinctures;

/**
 * An exception to be thrown when referring to an unknown tincture.
 * 
 * @author Luke Torjussen
 * @see Exception
 */
public class UnknownTinctureException extends Exception {

	private static final long serialVersionUID = 1330935986602368773L;

	/**
	 * Construct an UnknownTinctureException and set the message
	 * field to the given value.
	 * @param msg the message that contains details about the exception.
	 */
	public UnknownTinctureException(String msg) {
		super(msg);
	}

}
