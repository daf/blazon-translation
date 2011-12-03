package blazon.shared.numberconversion;

/**
 * An exception to be thrown when NumberConversion fails.
 * 
 * @author Luke Torjussen
 * @see Exception
 */
public class NumberConversionException extends Exception {

	private static final long serialVersionUID = 2997836748301771762L;

	/**
	 * Constructs a new exception with the specified detail message.
	 * 
	 * @param msg
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the Throwable.getMessage() method.
	 */
	public NumberConversionException(String msg) {
		super(msg);
	}
}
