public class Stern implements Mobile {
	static IllegalArgumentException error=new IllegalArgumentException("negativer Argument");
	protected double gewicht;
	
	public Stern(double gewicht) throws IllegalArgumentException {
		super();
		if (gewicht<0) throw error;
		else this.gewicht = gewicht;
	}

	@Override
	public double getGewicht() {
		return gewicht;
	}

	@Override
	public void balancieren() {
	}

	@Override
	public String toString() {
		return "Gewicht "+gewicht;//super.toString();
		//	return String.valueOf(gewicht);
	}
}
