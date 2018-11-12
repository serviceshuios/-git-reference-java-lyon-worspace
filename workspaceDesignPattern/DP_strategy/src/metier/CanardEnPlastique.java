package metier;

public class CanardEnPlastique extends Canard {

	public CanardEnPlastique() {
		super();
		comportementCancan = new CoinCoin();
		comportementVol = new NePasVoler();
	}

	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		System.out.println("JE SUIS UN CANARD EN PLASTIQUE");
	}

}
