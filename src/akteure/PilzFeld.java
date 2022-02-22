package akteure;

public class PilzFeld extends Feld {

	public PilzFeld(int number, Feld next) {

		super(number);
		setNextFeld(next);
	}

	public boolean addFigur(Figur figur) {
		figur.setPosition(this);
		feldFiguren.add(figur);// Zugriff
		return true;
	}

}
