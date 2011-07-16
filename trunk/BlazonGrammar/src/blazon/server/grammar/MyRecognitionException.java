package blazon.server.grammar;


import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;

public class MyRecognitionException extends RecognitionException {

	private static final long serialVersionUID = -2818407063731995291L;
	
	public String message;
	
	public MyRecognitionException(String message) {
		this.message = message;
	}
	
	public MyRecognitionException(String message, Exception e) {
		this.message = message + "\nCaught: " + e;
	}
	
	public MyRecognitionException(String message, IntStream input) {
		super(input);
		this.message = message;
		
	}
	
	
}
