package metier;

public class ScooterElectrique extends Scooter{

	public ScooterElectrique(String modele, String couler, int puissance) {
		super(modele, couler, puissance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void afficheCaracteristiques() {
		// TODO Auto-generated method stub
		System.out.println("Scooter electrique de mod�le " + modele+
				" de couleur"+ couleur+" de puissance "+puissance);
	}

	
}
