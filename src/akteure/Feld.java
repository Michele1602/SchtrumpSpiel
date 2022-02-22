package akteure;

import java.util.LinkedList;

import java.util.List;

import enums.Farbe;
import enums.Richtung;

public class Feld {

	private int number;
	/**
	 * @param nextFeld
	 */
	public Feld nextFeld;
	/**
	 * @param feldFiguren
	 */
	public List<Figur> feldFiguren;

	/**
	 * 
	 * @param number
	 */
	public Feld(int number) {
		this.number = number;
		feldFiguren = new LinkedList<>();
	}

	/**
	 * 
	 * @param number
	 * @param next
	 */
	public Feld(int number, Feld next) {

		this.number = number;
		feldFiguren = new LinkedList<>();
		this.nextFeld = next;
	}

	/**
	 * 
	 * @return liefert die Liste der Figuren im Feld
	 */
	public List<Figur> getfeldFiguren() {
		return feldFiguren;
	}

	/**
	 * 
	 * @return liefert die Nummer des Feldes
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 
	 * @param number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 
	 * @param next
	 */
	public void setNextFeld(Feld next) {
		this.nextFeld = next;
	}

	/**
	 * 
	 * @param figur
	 * @return true, wenn die Figur hinzugefügt wird
	 */
	public boolean addFigur(Figur figur) {
		for (int i = 0; i < feldFiguren.size(); i++) {
			feldFiguren.get(i).beeinflussen(figur);
			if (figur instanceof Fliege || figur instanceof Schlumpfine) {
				figur.beeinflussen(feldFiguren.get(i));
			}
		}
		figur.setPosition(this);
		feldFiguren.add(figur);// Zugriff
		return true;
	}

	/**
	 * 
	 * @param name
	 * @return liefert die Figur, die das Feld verlassen hat
	 */
	public Figur verlasseFeld(String name) {
		for (int i = 0; i < feldFiguren.size(); i++) {
			Figur f = feldFiguren.get(i);// figur holen

			if (f.getName().equals(name)) {
				feldFiguren.get(i).setPosition(null);
				return feldFiguren.remove(i); // remove die Figur auf die position i
			}
		}
		return null;

	}

	/**
	 * @param name
	 * @return die gesuchte Figur
	 */
	public Figur getFigur(String name) {
		for (int i = 0; i < feldFiguren.size(); i++) {
			Figur f = feldFiguren.get(i);// figur holen

			if (f.getName().equals(name)) {
				return f;
			}
		}
		return null;

	}

	/**
	 * 
	 * @param r
	 * @return liefert den nächsten Feld
	 */
	public Feld getNext(Richtung r) {

		if (r == Richtung.WEITER) {
			return nextFeld;
		} else {
			return nextFeld;
		}

	}

	/**
	 * 
	 * @param farbe
	 * @return liefert die Anzahl der Figuren mit gleichen Farben
	 */
	public int figurAnzahl(Farbe farbe) {
		int anzahl = 0;
		for (int i = 0; i < feldFiguren.size(); i++) {
			Figur figur = feldFiguren.get(i);// wir holen die Figur
			if (figur instanceof Schtrump) { // ist das ein schlumpf ?
				Schtrump schhumpf = (Schtrump) figur; // casten
				if (schhumpf.getFarbe().equals(farbe)) { // prüfen ob der Schlumpf die gleiche Farbe wie farbe
					anzahl++;
				}
			}

		}
		return anzahl;

	}

	@Override
	public String toString() {
		return ":" + number;
	}

}
