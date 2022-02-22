package interfaces;

import java.io.IOException;

/**
 * Erweitert das Spiel Zombieschlümpfe, so dass die aktuelle Spielstellung
 * gespeichert werden kann und auch so, dass eine gespeicherte Spielstellung
 * geladen werden kann. Nach dem laden muss das Spiel in einem bespielbaren
 * Zustand sein.
 * 
 * @author M. Gruendel, D. Dick
 * @since WS 2021/2022
 */
public interface ISpeicherbar {

	/**
	 * Die Methode speichert in eine Datei den momentanen Spielzustand, so dass nach
	 * dem Laden das Weiterspielen möglich ist.
	 * 
	 * @param dateiName Name der Datei bzw. den kompletten Pfad, wo die Datei
	 *                  gespeichert wird
	 */
	public void speichern(String dateiName) throws IOException;

	/**
	 * Die Methode liest eine Datei und konfiguriert das Spiel, wie es dort
	 * gespeichert ist, so dass nach dem Laden das Weiterspielen möglich ist.
	 * 
	 * Die Figuren müssen in ihrem korrekten Zustand Gesund/Zombie auf die Position
	 * gebracht werden, wie sie gespeichert wurden.
	 * 
	 * @param dateiName Der Name der Datei, wo die gewünschte Spielkonfiguration
	 *                  gespeichert ist.
	 * @return eine Instanz der Klasse, die IZombieSchluempfe implementiert
	 */
	public static ISchtrumpSpiel laden(String dateiName) throws Exception {
		throw new NoSuchMethodException("Methode laden(String) muss überschrieben werden.");
	}
}