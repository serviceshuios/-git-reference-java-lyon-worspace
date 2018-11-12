package org.v3.service;

import java.io.Serializable;

import javax.inject.Named;


/**
 * La classe service ClientService est associ�e � la classe m�tier Client.
 * Elle permet d'effectuer des op�rations sp�cifiques sur les clients ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@Named
public class ClientService implements IClientService, IClientFortuneService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2274328040607702852L;
	
//	/**
//	 * M�thode qui permet de tester si client est fortun� ou non
//	 * Chez ProxiBanque, la condition pour �tre consid�r� comme un client fortun�
//	 * est d'avoir un patrimoine (somme des soldes des comptes d'un client) sup�rieur � 500000 euros
//	 * @param client : le client � tester
//	 * @return true si le client est fortun�, false sinon
//	 */
//	@Override
//	public boolean isFortune(Client client) {
//		if (client.getCompteCourant().getSoldeCompte() + client.getCompteEpargne().getSoldeCompte() > 500000) {
//			return true;
//		} else return false;
//	}
//	
//	/**
//	 * M�thode permettant d'effectuer un placement boursier
//	 * @param client : le client concern� par le placement boursier
//	 * @param placement : le placement boursier choisi par le client
//	 * @param montant : le montant du placement
//	 * @throws SoldeInsuffisantException
//	 * @throws MontantNegatifException
//	 */
//	public void effectuerPlacementBourse (Client client, PlacementBourse placement, double montant) throws SoldeInsuffisantException, MontantNegatifException {
//		CompteEpargneService cs = new CompteEpargneService();
//		cs.debiter(client.getCompteEpargne(), montant);
//		placement.setMontantPlacement(montant);
//	}
}
