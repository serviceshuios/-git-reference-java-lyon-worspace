package service;

import metier.ConseillerClientele;
import metier.Gerant;

/**
 * Interface sp�cifique aux g�rants d'agences Proxibanque
 * @version 2.0
 */
public interface IGerantService {

	//public void ajouterConseillerClientele(Agence agence, ConseillerClientele conseillerClientele);
	public void ajouterConseillerClientele(Gerant gerant, ConseillerClientele conseillerClientele);
	
	//public void retirerConseillerClientele(Agence agence, ConseillerClientele conseillerClientele);
	public void retirerConseillerClientele(Gerant gerant, ConseillerClientele conseillerClientele);
	
	//public int[] auditerAgence (Agence agence);
	//public int[] auditerAgence (Gerant gerant);
	//public Collection<Client> auditerAgence(Gerant gerant);
	
}
