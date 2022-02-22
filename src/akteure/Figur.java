package akteure;

import java.util.ArrayList;

import enums.Richtung;
import enums.Zustand;

public abstract class Figur {
	
	private Feld position;
	private String name;
	private Zustand zustand;

	public Figur(String name) {
		this.name = name;
		this.zustand = Zustand.NICHTKRANK;
		this.position = null;

	}

	public String getName() {
		return name;
	}

	public Feld getPosition() {
		return position;
	}

	public void setPosition(Feld position) {
		this.position = position;
	}

	public abstract void beeinflussen(Figur figur);

	public boolean kannSichBewegen() {

		return true;

	}

	public abstract void bewegen(int augenzahl, ArrayList<Feld> brett, Richtung richtung, Feld start);

	public Zustand getZustand() {
		return zustand;
	}

	public void setZustand(Zustand zustand) {
		this.zustand = zustand;
	}

	@Override
	public String toString() {
		if (this.getZustand().equals(Zustand.KRANK)) {
			return getName() + getPosition().toString() + ":K";
		}
		return getName() + getPosition().toString();
	}

}
