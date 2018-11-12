package metier;

public class Leurre extends Canard {

	public Leurre() {
		super();
		comportementCancan = new CancanMuet();
		comportementVol = new NePasVoler();
	}

	@Override
	public void afficher() {
		System.out.println("JE SUIS UN LEURRE");

	}

}
