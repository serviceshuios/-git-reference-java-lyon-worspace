package service;

import metier.Automobile;
import metier.AutomobileEssence;
import metier.Scooter;
import metier.ScooterEssence;

public class FabriqueVehiculeEssence implements FabriqueVehicule {

	@Override
	public Automobile creeAutomobile(String modele, String couleur, 
			int puissance, double espace) {
		// TODO Auto-generated method stub
		return new AutomobileEssence(modele, couleur, puissance, espace);
	}

	@Override
	public Scooter creeScooter(String modele, String couleur, int puissance) {
		// TODO Auto-generated method stub
		return new ScooterEssence(modele, couleur, puissance);
	}

}
