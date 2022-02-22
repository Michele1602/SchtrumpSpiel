package akteure;

import java.util.ArrayList;
import java.util.List;

import enums.Richtung;
import enums.Zustand;

public class Schlumpfine extends Figur {
	/**
	 * 
	 * @param name
	 */
	public Schlumpfine(String name) {

		super(name);
		setZustand(Zustand.NICHTKRANK);
	}

	@Override
	public void beeinflussen(Figur figur) {

		
			figur.setZustand(Zustand.NICHTKRANK);
		

	}

	@Override
	public void bewegen(int augenzahl, ArrayList<Feld> brett, Richtung richtung, Feld startFeld) {

		Feld letzterFeld = startFeld;
		boolean b = false;
		for(int i=0; i<augenzahl; i++) {
			Feld p = brett.get(letzterFeld.getNumber()).getNext(richtung);
			List<Figur> fig = brett.get(p.getNumber()).feldFiguren;
			for (int j = 0; j < fig.size(); j++) {
				
				if (fig.get(j) instanceof Fliege) {
					
					b=true;
					return; // Die Schlumpfine kann nicht auf Feldern landen, auf denen sich
					// die Fliege befindet
				}
			}
			letzterFeld = p;
		}
		letzterFeld = startFeld;
		if(!b) {
		for (int i = 0; i < augenzahl; i++) {

			Feld p = brett.get(letzterFeld.getNumber()).getNext(richtung);
			List<Figur> fig = brett.get(p.getNumber()).feldFiguren;
			for (int j = 0; j < fig.size(); j++) {
				
//				if (fig.get(j) instanceof Fliege) {
//					Figur ff = brett.get(this.getPosition().getNumber()).verlasseFeld(this.getName());
//
//					brett.get(startFeld.getNumber()).addFigur(this);
//
//					return; // Die Schlumpfine kann nicht auf Feldern landen, auf denen sich
//					// die Fliege befindet
//				}
				beeinflussen(fig.get(j));
			}

			Figur ff = brett.get(letzterFeld.getNumber()).verlasseFeld(this.getName());

			brett.get(p.getNumber()).addFigur(ff);

		letzterFeld = p;
		}

	}

	}

}
