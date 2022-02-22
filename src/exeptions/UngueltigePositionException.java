package exeptions;

import java.util.Arrays;

public class UngueltigePositionException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UngueltigePositionException()  {
		super();
	}
	public String getMessage() {
		return "Die Position der Figur ist ungültig";
	}

	@Override
	public String toString() {
		return "UngueltigePositionException [getMessage()=" + getMessage() + ", getLocalizedMessage()="
				+ getLocalizedMessage() + ", getCause()=" + getCause() + ", toString()=" + super.toString()
				+ ", fillInStackTrace()=" + fillInStackTrace() + ", getStackTrace()=" + Arrays.toString(getStackTrace())
				+ ", getSuppressed()=" + Arrays.toString(getSuppressed()) + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
