package akteure;

import java.util.ArrayList;

public class SpielBrett {

	ArrayList<Feld> felder = new ArrayList<Feld>(37);

	public SpielBrett() {

		for (int i = 0; i < 37; i++) {
			felder.add(new Feld(i));// (i,i+1)

		}
		for (int i = 0; i < 36; i++) {
			felder.get(i).setNextFeld(felder.get(i + 1));
		}

		felder.set(11, new TuberoseFeld(11, felder.get(12)));
		felder.get(10).setNextFeld(felder.get(11));

		felder.set(3, new AbzweigungFeld(3, felder.get(4), felder.get(8)));// 3, 4, 8
		felder.get(2).setNextFeld(felder.get(3));

		felder.get(7).setNextFeld(felder.get(15));// 7, 15

		felder.get(35).setNextFeld(felder.get(1)); // 35, 1

		felder.set(36, new Dorf(36, null));// 36, 36
		felder.get(36).setNextFeld(felder.get(36));

		felder.set(31, new AbzweigungFeld(31, felder.get(32), felder.get(36)));// 31, 32, 36
		felder.get(30).setNextFeld(felder.get(31));
		felder.set(17, new FlussFeld(17, felder.get(18)));// (Felder 16, 17, 25, 26, 27 ; Fliege und Schlumpfine

		felder.set(16, new FlussFeld(16, felder.get(17)));// (Felder 16, 17, 25, 26, 27 ; Fliege und Schlumpfine
		felder.get(15).setNextFeld(felder.get(16));
		felder.set(27, new FlussFeld(27, felder.get(28)));// (Felder 16, 17, 25, 26, 27 ; Fliege und Schlumpfine

		felder.set(26, new FlussFeld(26, felder.get(27)));// (Felder 16, 17, 25, 26, 27 ; Fliege und Schlumpfine
		felder.set(25, new FlussFeld(25, felder.get(26)));// (Felder 16, 17, 25, 26, 27 ; Fliege und Schlumpfine

		felder.set(24, new PilzFeld(24, felder.get(25)));
		felder.get(27).setNextFeld(felder.get(28));

		felder.get(23).setNextFeld(felder.get(24));
	}

}
