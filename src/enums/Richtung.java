package enums;

public enum Richtung {
	/**
	 * ein Feld weiter
	 */
	WEITER(1),
	/**
	 * fuenf Felder weiter
	 */

	ABZWEIGEN(5);
	int i;

	private Richtung(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

}
