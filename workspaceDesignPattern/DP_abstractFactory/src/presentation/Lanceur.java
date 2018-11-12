package presentation;

import metier.Automobile;
import metier.Scooter;
import service.FabriqueVehicule;
import service.FabriqueVehiculeElectrique;
import service.FabriqueVehiculeEssence;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FabriqueVehicule f1 = new FabriqueVehiculeElectrique();
		FabriqueVehicule f2 = new FabriqueVehiculeEssence();
		
		Automobile auto1= f1.creeAutomobile("mercedes", "grise", 200, 180);
		Automobile auto2= f2.creeAutomobile("mercedes", "rose", 100, 150);
		
		Scooter scooter1 = f1.creeScooter("mercedes", "violet", 300);
		Scooter scooter2 = f2.creeScooter("mercedes", "noir", 450);

		auto1.afficheCaracteristiques();
		auto2.afficheCaracteristiques();
		scooter1.afficheCaracteristiques();
		scooter2.afficheCaracteristiques();
	}

}
