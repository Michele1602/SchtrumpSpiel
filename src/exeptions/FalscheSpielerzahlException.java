package exeptions;

import java.util.Arrays;

public class FalscheSpielerzahlException extends Exception{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FalscheSpielerzahlException() {
		super();
	}
	public String getMessage() {
		return "Die Spielerzahl ist falsch";
	}
	@Override
	public String toString() {
		return "FalscheSpielerzahlException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
}
