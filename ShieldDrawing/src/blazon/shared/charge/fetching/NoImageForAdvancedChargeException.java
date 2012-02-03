package blazon.shared.charge.fetching;

import blazon.shared.shield.charges.AdvancedCharge;

public class NoImageForAdvancedChargeException extends Exception {

	private static final long serialVersionUID = 4244771031841398945L;

	private AdvancedCharge advCharge;
	
	public NoImageForAdvancedChargeException() {}

	public NoImageForAdvancedChargeException(AdvancedCharge advCharge) {
		this.advCharge = advCharge;
	}

	public String getMissingImageInformation() {
		return advCharge.getTextDescription();
	}
}
