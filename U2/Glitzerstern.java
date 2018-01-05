public class Glitzerstern extends Stern {

	public Glitzerstern(double gewicht) {
		super(gewicht);
	}

	public void dekorieren(){
		gewicht=gewicht+1;
	}
}
