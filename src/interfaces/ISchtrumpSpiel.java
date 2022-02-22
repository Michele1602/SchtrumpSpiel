package interfaces;

import enums.Farbe;
import enums.Richtung;

/**
 * Das Spiel Die SchtrumpSpiel ist ein Brettspiel mit unterschiedlichen Figuren,
 * die sich durch unterschiedliche Felder entlang eines Spielbrettes (den
 * Schlumpfwald) in Richtung Dorf (das Ziel) bewegen. Waehrend die Schluempfe
 * den Schlumpfwald durchqueren, koennen sie ihren Zustand mehrmals aendern
 * (Gesund <-> krank(Zombie), da sie von anderen Figuren aus dem Spiel oder von
 * speziellen Feldern beeinflusst werden.
 * 
 */
public interface ISchtrumpSpiel {

	/*
	 * *********************************************************************
	 * *************************** KONSTRUKTOREN ***************************
	 * 
	 * "Klasse" steht fuer den Name der Klasse, die das Interface implementiert
	 * 
	 * *********************************************************************
	 */

	/*
	 * In diese Konstruktur werden ausschliesslich die spielenden Farben
	 * bekanntgegeben. Alle Figuren werden auf ihren Standardpositionen positioniert
	 * (d.h. Schluempfe auf Feld 0, Fliege auf Feld 20 und Oberschlumpf auf Feld
	 * 29). Fuer jede spielende Farbe werden 4 Schluempfe erzeugt.
	 * 
	 * Die ausfuehrliche Erklaerungen zur Methode ist aus der Aufgabestellung zu
	 * entnehmen.
	 * 
	 * @param farben - Die spielenden Farben
	 * 
	 * -----------------------------------------------------------------------
	 * public Klasse (Farbe... farben);
	 * -----------------------------------------------------------------------
	 * 
	 */

	/*
	 * In diesem Konstruktor werden neben den spielenden Farben auch die
	 * Startposition der Figuren bekanntgegeben, die nicht auf ihren Standardfelder
	 * zu positionieren sind.
	 * 
	 * Die ausfuehrliche Erklaerungen zur Methode ist aus der Aufgabestellung zu
	 * entnehmen.
	 * 
	 * @param configuration - String mit den Startpositionen der Figuren. Zum
	 * Beispiel: "BLAU-A:30:Z, BLAU-B:28, BLAU-C:30, BLAU-D:28, GELB-A:30,
	 * GELB-B:28, GELB-C:30, GELB-D:28, Bzz:20, Doc:29"
	 * 
	 * @param farben - Die spielenden Farben
	 * 
	 * -----------------------------------------------------------------------
	 * public Klasse (String configuration, Farbe... farben);
	 * -----------------------------------------------------------------------
	 * 
	 */

	/*
	 * *********************************************************************
	 * ****************************** METHODEN *****************************
	 * *********************************************************************
	 */

	/**
	 * 
	 * @param figurName - Der Name bzw. die eindeutige Identifikation der Figur,
	 *                  welche bewegt werden soll
	 * @param augenzahl - Der gew�rfelte Wert entspricht die Anzahl von Felder, die
	 *                  die Figur vorr�cken muss
	 * @return true, wenn die Bewegungs ausgef�hrt werden konnte, sonst false.
	 */
	public boolean bewegeFigur(String figurName, int augenzahl);

	/**
	 * 
	 * @param figurName - Der Name bzw. die eindeutige Identifikation der Figur,
	 *                  welche bewegt werden soll
	 * @param augenzahl - Der gewuerfelte Wert entspricht die Anzahl von Felder, die
	 *                  die Figur vorr�cken muss
	 * @param richtung  - Richtungsangaben fuer die Verzweigungsfelder
	 * @return true, wenn die Bewegungs ausgefuehrt werden konnte, sonst false.
	 */
	public boolean bewegeFigur(String figurName, int augenzahl, Richtung richtung);

	/**
	 * 
	 * 
	 * @param name der Name der Figur
	 * @return die Position der Figur, wenn sie gefunden wurde; sonst -1
	 */

	/**
	 * Liefert die Position (die Feldnummer) der Figur mit dem angegebenen Namen.
	 * 
	 * @param name - Der Name bzw. die eindeutige Identifikation der Figur
	 * @return Feldnummer der Figur oder -1, falls sie nicht gefunden werden konnte.
	 */
	public int getFeldnummer(String name);

	/**
	 * Ermittelt, ob die Figur mit dem angegebenen Namen krank ist oder nicht.
	 * 
	 * @param name - Der Name bzw. die eindeutige Identifikation der Figur
	 * @return true, wenn die Figur ein Zombie ist, sonst false
	 */
	public boolean istKrank(String name);

	/**
	 * Methode liefert die Farbe des Spieler der aktuell spielen darf.
	 * 
	 * 
	 * @return die Farbe des Spieler, der aktuell spielen darf
	 */
	public Farbe getFarbeAmZug();

	/**
	 * Liefert die Farbe des Spielers, der das Spiel gewonnen hat.
	 * 
	 * @return Farbe des Spielgewinners, oder null, wenn es noch keinen Gewinner
	 *         gibt
	 */
	public Farbe gewinner();

	/**
	 * 
	 * @return eine textuelle Repraesentation des Spiels.
	 */
	@Override
	public String toString();

}