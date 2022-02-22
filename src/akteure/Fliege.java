package akteure;

import java.util.ArrayList;
import java.util.List;

import enums.Richtung;
import enums.Zustand;

public class Fliege extends Figur {

	/**
	 * 
	 * @param name
	 */
	public Fliege(String name) {
		super(name);
		setZustand(Zustand.KRANK);// die Fliege ist immer krank

	}

	@Override
	public void beeinflussen(Figur figur) {

		figur.setZustand(Zustand.KRANK);

	}

	@Override
	public void bewegen(int augenzahl, ArrayList<Feld> brett, Richtung richtung, Feld startFeld) {

		Feld nexteFeld = startFeld;
		for (int i = 0; i < augenzahl; i++) { // Suche nach der naechste Position der Figur
			Feld f = brett.get(nexteFeld.getNumber());
			nexteFeld = f.getNext(richtung);
		}

		List<Figur> fig = brett.get(nexteFeld.getNumber()).feldFiguren;
		for (int i = 0; i < fig.size(); i++) { // Suche nach der Fliege und dem SchtrumpDoc im Feld
			if (fig.get(i) instanceof SchtrumpDoc || fig.get(i) instanceof Schlumpfine) {
				return; // Fliege kann nicht auf Feldern landen, auf denen sich
				// der SchtrumpDoc oder die Schlumpfine befindet
			}
		}

		brett.get(startFeld.getNumber()).verlasseFeld(this.getName());
		Feld f = brett.get(nexteFeld.getNumber());
		if (f instanceof TuberoseFeld || f instanceof Dorf) {
			nexteFeld = startFeld;
		}
		brett.get(nexteFeld.getNumber()).addFigur(this);

	}

}
