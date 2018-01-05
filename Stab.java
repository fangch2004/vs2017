public class Stab implements Mobile {

	double laenge_l, laenge_r;
	Mobile mobile_l, mobile_r;
	
	
	public Stab(double laenge, Mobile mobile_l, Mobile mobile_r) {
		super();
		this.mobile_l = mobile_l;
		this.mobile_r = mobile_r;
		laenge_l=laenge;
		laenge_r=0;
		balansieren();
	}

	@Override
	public double getGewicht() {
		return mobile_l.getGewicht()+mobile_r.getGewicht();
	}

	@Override
	public void balancieren() {
		laenge_r=(mobile_l.getGewicht()*laenge_l)/(mobile_r.getGewicht()+mobile_l.getGewicht());
		laenge_l=laenge_l-laenge_r;
	}
	
	@Override
	public String toString() {
		return "Links: "+this.laenge_l+", "+this.mobile_l+" Rechts: "+this.laenge_r+", "+this.mobile_r;
	}

}
