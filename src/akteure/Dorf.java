package akteure;


public class Dorf extends Feld {

	/**
	 * 
	 * @param number
	 * @param next
	 */
	public Dorf(int number, Feld next) {
		
		super(number, next);
		
	}
	public boolean addFigur(Figur figur) {
		if(figur instanceof Fliege) {
			return false;
		}
		for (int i = 0; i < feldFiguren.size(); i++) {
			feldFiguren.get(i).beeinflussen(figur);

		}
		figur.setPosition(this);
		feldFiguren.add(figur);// Zugriff
return true;
	}
	

	
}
