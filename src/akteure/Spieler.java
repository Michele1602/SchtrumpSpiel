package akteure;

import java.util.ArrayList;
import java.util.List;

import enums.Farbe;

public class Spieler {
	private Farbe farbe;
	private Schtrump schf;
	private List<Figur> meineFiguren = new ArrayList<>();

	public Spieler(Farbe farbe) {
		this.farbe = farbe;

		meineFiguren.add(new Schtrump(farbe, farbe.name() + "-A"));
		meineFiguren.add(new Schtrump(farbe, farbe.name() + "-B"));
		meineFiguren.add(new Schtrump(farbe, farbe.name() + "-C"));
		meineFiguren.add(new Schtrump(farbe, farbe.name() + "-D"));

	}

	public Schtrump getSchf() {
		return schf;
	}

	public Farbe getFarbe() {
		return farbe;
	}

	public List<Figur> getFigurenSpieler() {

		return meineFiguren;

	}

	@Override
	public String toString() {

		return this.farbe.toString();
	}


}
