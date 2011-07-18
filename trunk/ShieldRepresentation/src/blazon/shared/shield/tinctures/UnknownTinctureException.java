package blazon.shared.shield.tinctures;

/**
 * An exception to be thrown when referring to an unknown tincture.
 * 
 * @author Luke Torjussen
 * @see Exception
 */
public class UnknownTinctureException extends Exception {

	private static final long serialVersionUID = 1330935986602368773L;

	public UnknownTinctureException(String msg) {
		super(msg);
	}

}
