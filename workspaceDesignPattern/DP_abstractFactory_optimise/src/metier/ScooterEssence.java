package metier;

public class ScooterEssence extends Scooter {

	public ScooterEssence(String modele, String couleur, int puissance) {
		super(modele, couleur, puissance);
	}

	@Override
	public void afficheCaracteristiques() {
				System.out.println("Scooter essence de mod�le " + modele+
						" de couleur"+ couleur+" de puissance "+puissance);

	}

}
