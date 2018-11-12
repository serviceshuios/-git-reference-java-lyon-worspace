package lanceur;

import metier.Boisson;
import metier.Caramel;
import metier.Chocolat;
import metier.Colombia;
import metier.Expresso;

public class ApplicationDecorateur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Boisson b1 = new Expresso();
		System.out.println(b1.getDescription()+ " cout = "+b1.cout()+" €");
		
		Boisson b2 = new Colombia();
		b2 = new Caramel(b2);
		b2 = new Chocolat(b2);
		System.out.println(b2.getDescription()+ " cout = "+b2.cout()+" €");
	}

}
