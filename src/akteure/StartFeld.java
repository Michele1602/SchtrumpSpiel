package akteure;

import enums.Zustand;

public class StartFeld extends Feld {

	public StartFeld(int number, Feld next) {

		super(number, next);
	}

	// Figuren in die Liste hinzufügen
	public boolean addFigur(Figur figur) {

		figur.setZustand(Zustand.NICHTKRANK);
		feldFiguren.add(figur);// Zugriff
		return true;
	}
}
