package service;

import metier.Automobile;
import metier.Scooter;

public interface FabriqueVehicule {

	public Automobile creeAutomobile(String modele, String couleur,
			int puissance, double espace);
	
	public Scooter creeScooter(String modele, String couleur,
			int puissance);
}
