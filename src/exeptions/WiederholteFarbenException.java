package exeptions;

import java.util.Arrays;

public class WiederholteFarbenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WiederholteFarbenException() {
		super();
	}

	public String getMessage() {
		return "eine Spielfarbe komm mehr als einmal im Spiel vor";
	}

	@Override
	public String toString() {
		return "WiederholteFarbenException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
