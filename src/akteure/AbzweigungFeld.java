package akteure;

import enums.Richtung;

public class AbzweigungFeld extends Feld {

	private Feld abzweigen;

	/**
	 * 
	 * @param number
	 * @param gerade
	 * @param ab
	 */

	public AbzweigungFeld(int number, Feld gerade, Feld ab) {

		super(number, gerade);
		this.abzweigen = ab;
	}

	public Feld getNext(Richtung r) {

		if (r == Richtung.WEITER) {
			return nextFeld;
		} else {
			return abzweigen;
		}

	}

}