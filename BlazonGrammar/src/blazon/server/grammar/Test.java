package blazon.server.grammar;

import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; i++) {
			try {
				if (i < 50) {
					System.out.println("yes");
				}
				else {
					throw new NoViableAltException();
				}
			}
			catch (RecognitionException re) { 
				System.out.println("Caught re");
			}
		}
		
	}

}
