package akteure;

import java.util.ArrayList;

import enums.Farbe;
import enums.Richtung;
import enums.Zustand;

public class Schtrump extends Figur {

	private Farbe farbe;

	/**
	 * 
	 * @param farbe
	 * @param name
	 */
	public Schtrump(Farbe farbe, String name) {
		super(name);
		this.farbe = farbe;
		setZustand(Zustand.NICHTKRANK);
	}

	/**
	 * 
	 * @return liefert die Farbe der Figur
	 */
	public Farbe getFarbe() {
		return farbe;
	}

	@Override
	public void beeinflussen(Figur figur) {

		// eine andere Figur beeinflüsst die Figur
//		if (figur.getZustand().equals(Zustand.KRANK)) {
//			setZustand(Zustand.KRANK);
//		}

		// wenn eine Figur Krank ist, beeinflüsst sie die kommende Figur
		if (getZustand().equals(Zustand.KRANK)) {
			figur.setZustand(Zustand.KRANK);
		}

	}

	@Override
	public void bewegen(int augenzahl, ArrayList<Feld> brett, Richtung richtung, Feld startFeld) {

		Feld start = startFeld;
		Zustand zustand = this.getZustand();
		for (int i = 0; i < augenzahl; i++) {

			Feld p = brett.get(startFeld.getNumber()).getNext(richtung);
			if (brett.get(p.getNumber()) instanceof Dorf && this.getZustand().equals(Zustand.KRANK)) {
				brett.get(startFeld.getNumber()).verlasseFeld(this.getName());
				brett.get(start.getNumber()).addFigur(this);
				this.setZustand(Zustand.NICHTKRANK);
				return;
			}

			brett.get(startFeld.getNumber()).verlasseFeld(this.getName());

			brett.get(p.getNumber()).addFigur(this);

			startFeld = p;
		}
		if (brett.get(startFeld.getNumber()) instanceof PilzFeld) {
			Feld pos = startFeld;
			if (this.getZustand().equals(Zustand.KRANK)) {
				this.setZustand(Zustand.NICHTKRANK);
				startFeld = brett.get(0);
				Figur ff = brett.get(pos.getNumber()).verlasseFeld(this.getName());
				brett.get(startFeld.getNumber()).addFigur(ff);
			}
		}
		if (brett.get(startFeld.getNumber()) instanceof FlussFeld) {
			brett.get(startFeld.getNumber()).verlasseFeld(this.getName());
			brett.get(start.getNumber()).addFigur(this); // die Figur behält ihre ursprüngliche Position bei
			setZustand(zustand); // die Figur behält ihren ursprünglichen Zustand bei
		}

	}

}
