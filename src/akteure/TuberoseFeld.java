package akteure;

import enums.Zustand;

public class TuberoseFeld extends Feld {
	/**
	 * 
	 * @param number
	 * @param next
	 */
	public TuberoseFeld(int number, Feld next) {

		super(number, next);
	}

	// Figuren in die Liste hinzufügen
	public boolean addFigur(Figur figur) {
		if (figur instanceof Fliege) {
			return false;
		}
		figur.setZustand(Zustand.NICHTKRANK);
		figur.setPosition(this);
		feldFiguren.add(figur);// Zugriff
		return true;
	}

}
