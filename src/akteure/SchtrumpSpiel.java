package akteure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.LinkedList;

import java.util.List;
import java.util.StringJoiner;

import enums.Farbe;
import enums.Richtung;
import enums.Zustand;
import exeptions.FalscheSpielerzahlException;
import exeptions.UngueltigePositionException;
import exeptions.WiederholteFarbenException;
import interfaces.ISpeicherbar;
import interfaces.ISchtrumpSpiel;

/**
 * 
 * @author Michele Fotsi
 *
 */
public class SchtrumpSpiel implements ISchtrumpSpiel, ISpeicherbar {

	int indexSpieler = 0;
	private SpielBrett spielBrett;
	private List<Spieler> spieler;

	/**
	 * 
	 * @param farben - die spielenden Farben
	 * @throws UngueltigePositionException
	 * @throws FalscheSpielerzahlException
	 * @throws WiederholteFarbenException
	 */
	public SchtrumpSpiel(Farbe... farben)
			throws UngueltigePositionException, FalscheSpielerzahlException, WiederholteFarbenException {

		spieler = new LinkedList<>();
		spielBrett = new SpielBrett();

		if (farben.length == 0 || farben.length > 4) {
			throw new FalscheSpielerzahlException();
		}

		for (int i = 0; i < farben.length - 1; i++) {
			for (int j = i + 1; j < farben.length; j++) {
				if (farben[i].equals(farben[j])) { // wenn die gleiche Farbe kommt zweimal
					throw new WiederholteFarbenException();
				}
			}
		}

		// Spieler erzeugen und in einer Liste hinzugefügen.
		for (int i = 0; i < farben.length; i++) {
			spieler.add(new Spieler(farben[i]));
			// jede Spieler und seine Figuren in der Liste hinzufügen
			List<Figur> meineFiguren = spieler.get(i).getFigurenSpieler();

			// setze die Figuren auf die position 0
			for (int j = 0; j < meineFiguren.size(); j++) {
				spieler.get(i).getFigurenSpieler().get(j).setPosition(spielBrett.felder.get(0));
				spielBrett.felder.get(0).addFigur(meineFiguren.get(j));
			}
		}
		spielBrett.felder.get(1).addFigur(new Schlumpfine("Schlumpfine"));
		spielBrett.felder.get(29).addFigur(new SchtrumpDoc("Doc"));
		spielBrett.felder.get(20).addFigur(new Fliege("Fliege"));

	}

	/**
	 * 
	 * @param configuration String mit den Startpositionen der Figuren. Zum Beispiel:
	 * "BLAU-A:30:Z, BLAU-B:28, BLAU-C:30, BLAU-D:28, GELB-A:30, GELB-B:28,
	 * GELB-C:30, GELB-D:28, Fliege:20, Doc:29"
	 * @param farben - die spielenden Farben
	 * @throws UngueltigePositionException
	 * @throws FalscheSpielerzahlException
	 * @throws WiederholteFarbenException
	 */
	public SchtrumpSpiel(String configuration, Farbe... farben)
			throws UngueltigePositionException, FalscheSpielerzahlException, WiederholteFarbenException {

		this(farben); // erster Konstruktor aufrufen

		String[] str = configuration.trim().split(",");
		List<String> farbe = new LinkedList<>();
		int zaehler = 0;

		for (int i = 0; i < str.length; i++) {
			String[] str2 = str[i].split(":");

			String[] str3 = str2[0].split("-"); // [GELB, A]
			farbe.add(str3[0]);
			String tmpFarbe = farbe.get(0);
			if (farbe.get(i).equals(tmpFarbe)) {
				zaehler++;

			}
			if (zaehler > 4) {
				throw new WiederholteFarbenException();
			}

			String figurName = str2[0];
			int position = Integer.parseInt(str2[1]);

			if (position < 0 || position > 36) {
				throw new UngueltigePositionException();
			}
			int altPosition = getFeldnummer(figurName);
			Figur fig = spielBrett.felder.get(altPosition).verlasseFeld(figurName);

			if ((str2.length > 2 && str2[2].equals("K")) || fig instanceof Fliege) {
				fig.setZustand(Zustand.KRANK);
			}

			spielBrett.felder.get(position).addFigur(fig);
			fig.getZustand();
		}

	}
/**
 * * Bewegt die Figur mit dem angegebenen Namen um die gewuerfelte Augenzahl
	 * weiter. Die Bewegungsrichtung ist hier immer WEITER.
	 * 
	 * liefert true, wenn die Bewegungs ausgef�hrt werden konnte, sonst false.
 */
	@Override
	public boolean bewegeFigur(String figurName, int augenzahl) {

		return bewegeFigur(figurName, augenzahl, Richtung.WEITER);
	}
/**
 * 	 * Bewegt die Figur mit dem angegebenen Namen um die gewuerfelte Augenzahl
	 * weiter. Die Bewegungsrichtung wird hier anhand des Parameters "richtung"
	 * angegeben.
	 * liefert true, wenn die Bewegungs ausgef�hrt werden konnte, sonst false.
 */
	@Override
	public boolean bewegeFigur(String figurName, int augenzahl, Richtung richtung) {

		if (gewinner() != null) { // wenn es ein gewinner gibt, dann darf sich die Figur nicht mehr bewegen
			return false;
		}

		int altPosition = getFeldnummer(figurName);
		Feld feld = spielBrett.felder.get(altPosition);

		Figur figur = feld.getFigur(figurName);
		figur.bewegen(augenzahl, spielBrett.felder, richtung, feld);

		indexSpieler = (indexSpieler + 1) % spieler.size(); // Index des Spieler am Zug
		return true;
	}
/**
 * Liefert die Position (die Feldnummer) der Figur mit dem angegebenen Namen.
 */
	@Override
	public int getFeldnummer(String name) {

		for (int i = 0; i < spielBrett.felder.size(); i++) {
			if (spielBrett.felder.get(i).getFigur(name) != null) {
				return i;
			}
		}
		return -1; // kein gültiges Feld
	}

	@Override
	public boolean istKrank(String name) {

		// Suche nach der Figur im SpielBrett
		for (int i = 0; i < spielBrett.felder.size(); i++) {
			Figur f = spielBrett.felder.get(i).getFigur(name); // liefert eine Figur
			if (f != null) {
				return f.getZustand().equals(Zustand.KRANK);
			}
		}

		return false;
	}

	@Override
	public Farbe getFarbeAmZug() {

		return spieler.get(indexSpieler).getFarbe();

	}

	@Override
	public Farbe gewinner() {

		Farbe f;
		Feld feld = spielBrett.felder.get(36);
		for (int i = 0; i < spieler.size(); i++) {

			f = spieler.get(i).getFarbe();

			int anzahlFiguren = feld.figurAnzahl(f);

			if (anzahlFiguren == 4) {
				return f;
			}

		}
		return null;
	}

	@Override
	public String toString() {
		List<Figur> listFiguren = new LinkedList<>();
		for (int i = 0; i < spielBrett.felder.size(); i++) {
			if (spielBrett.felder.get(i).feldFiguren.size() > 0) {
				for (int j = 0; j < spielBrett.felder.get(i).feldFiguren.size(); j++) {
					listFiguren.add(spielBrett.felder.get(i).feldFiguren.get(j));
				}
			}
		}
		String tmpString = "[";

		if (listFiguren.size() >= 1) {
			tmpString += listFiguren.get(0).toString();
		}

		for (int i = 1; i < listFiguren.size(); i++) {
			tmpString += ", ";
			tmpString += listFiguren.get(i).toString();
		}
		tmpString += "]";

		return tmpString;

	}

	@Override
	public void speichern(String dateiName) throws IOException {

		FileWriter schreiber = new FileWriter(dateiName);

		BufferedWriter bw = new BufferedWriter(schreiber);
		String conf = this.toString();

		bw.write(conf.substring(1, conf.length() - 1));
		bw.newLine();
		StringJoiner sj = new StringJoiner(",");
		for (Spieler spieler2 : spieler) {
			sj.add(spieler2.getFarbe().toString());

		}
		bw.write(sj.toString());
		bw.newLine();

		bw.write("" + this.indexSpieler);
		bw.close();
		schreiber.close();

	}

	public static ISchtrumpSpiel laden(String dateiName) throws Exception {

		File file = new File(dateiName);

		FileReader fileReader = new FileReader(file);
		BufferedReader bf = new BufferedReader(fileReader);

		String conf = bf.readLine();
		String[] farben = bf.readLine().split(",");
		String position = bf.readLine();
		Farbe[] farbFiguren = new Farbe[farben.length];
		for (int i = 0; i < farbFiguren.length; i++) {
			farbFiguren[i] = Farbe.valueOf(farben[i].trim());

		}

		SchtrumpSpiel z = new SchtrumpSpiel(conf, farbFiguren);
		z.indexSpieler = Integer.parseInt(position.trim());
		bf.close();
		return z;

	}

}
