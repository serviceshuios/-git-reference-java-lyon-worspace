package presentation;

import java.util.List;

import ws.BanqueService;
import ws.BanqueWS;
import ws.Compte;

public class Lanceur {

	public static void main(String[] args) {
		BanqueService banqueService = new BanqueWS().getBanqueServicePort();
		System.out.println("CONVERSION");
		banqueService.conversionED(100);
		System.out.println("CONSULTER UN COMPTE");
		Compte c = banqueService.getCompte(10);
		System.out.println(c);
		System.out.println("LISTER LES COMPTES");
		List<Compte> l = banqueService.getComptes();
		for(Compte cp:l)
		{
			System.out.println(cp);
		}
	}
}
