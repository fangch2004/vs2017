public class Test {

	public static void main(String[] args) {
		Stern s1=new Stern(2);
		Glitzerstern s2=new Glitzerstern(4);	
		Stern s3=new Stern(9);	
		Stab st=new Stab(9,s1,s2);
		Stab st1=new Stab(10,st,s3);
		System.out.println(st1);
		s2.dekorieren();s2.dekorieren();s2.dekorieren();
		st.balancieren();
		st1.balancieren();
		System.out.println(st1);
		
	}

}
