package akteure;

import java.util.ArrayList;

import enums.Richtung;
import enums.Zustand;

public class SchtrumpDoc extends Figur {

	/**
	 * 
	 * @param name
	 */
	public SchtrumpDoc(String name) {
		super(name);
		setZustand(Zustand.NICHTKRANK);

	}

	public boolean kannSichBewegen() {

		return false;

	}

	
	@Override
	public void beeinflussen(Figur figur) {
		
		figur.setZustand(Zustand.NICHTKRANK);

	}

	@Override
	public void bewegen(int augenzahl, ArrayList<Feld> brett, Richtung richtung, Feld start) {
		
	}



}
