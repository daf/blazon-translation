package blazon.shared.shield.diagnostic;

import java.io.Serializable;
/**
 * A diagnostic can be added to a shield to store information 
 * from errors, which can then be displayed on the client.
 * @author Luke Torjussen
 *
 */
public class ShieldDiagnostic implements Serializable {

	private static final long serialVersionUID = 8664085052227797856L;

	/**
	 * An enum to represent how severe a diagnostic record is.
	 * @author Luke Torjussen
	 *
	 */
	public enum LogLevel {
		/**
		 * INFO - least severe diagnostic, used for logging useful messages.
		 */
		INFO,
		/**
		 * WARN - middle severity diagnostic, can continue to draw shield.
		 */
		WARN,
		/**
		 * ERROR - most severe diagnostic, can not continue to draw shield.
		 */
		ERROR
	}
	
	private LogLevel level;
	private String message;
	
	private ShieldDiagnostic() {}
	
	/**
	 * Build a ShieldDiagnostic setting the log level and message to the given parameters.
	 * @param level the severity of the diagnostic.
	 * @param message the message that explains why this diagnostic was constructed.
	 * @return a ShieldDiagnostic object representing the given message.
	 */
	public static ShieldDiagnostic build(final LogLevel level, final String message) {
		if (level == null || message == null) {
			throw new IllegalArgumentException("Can not build a ShieldDiagnostic with null log level or message.");
		}
		ShieldDiagnostic diag = new ShieldDiagnostic();
		diag.level = level;
		diag.message = message;
		//diag.exception = null;
		return diag;
	}
	
	/**
	 * Get the reason for the diagnostic being created.
	 * @return a string containing the reason for the diagnostics construction.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * Get the severity of the diagnostic.
	 * @return a log level value representing the severity of the diagnostic.
	 */
	public LogLevel getSeverity() {
		return level;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ShieldDiagnostic{level=").append(level);
		sb.append(":message=").append(message).append("}");
		return sb.toString();
	}
}
