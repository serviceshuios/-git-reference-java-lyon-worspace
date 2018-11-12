package org.v3.service;

import java.io.Serializable;

import javax.inject.Named;

import org.v3.metier.ConseillerClientele;
import org.v3.metier.Gerant;



/**
 * La classe service GerantService est associ�e � la classe m�tier Gerant.
 * Elle permet d'effectuer des op�rations sp�cifiques � un g�rant ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@Named
public class GerantService implements IGerantService, Serializable  {
	
//	/**
//	 * M�thode permettant d'affecter un conseiller client�le � une agence bancaire
//	 * @param agence : l'agence bancaire � laquelle on veut associer un conseiller client�le
//	 * @param conseillerClientele : le conseiller client�le � affecter � l'agence bancaire
//	 */
//	public void ajouterConseillerClientele(Agence agence, ConseillerClientele conseillerClientele) {
//		// Ajout du conseiller client�le � la collection de conseillers client�les de l'agence
//		agence.getConseillersClienteleAgence().add(conseillerClientele);
//		
//		// Valorisation de l'attribut monAgence du conseiller client�le
//		conseillerClientele.setMonAgence(agence);
//	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3014282957770127885L;

	/**
	 * M�thode permettant d'affecter un conseiller client�le � l'agence bancaire du g�rant
	 * @param gerant : le g�rant de l'agence bancaire � laquelle on veut associer un conseiller client�le
	 * @param conseillerClientele : le conseiller client�le � affecter � l'agence bancaire
	 */
	public void ajouterConseillerClientele(Gerant gerant, ConseillerClientele conseillerClientele) {
		// Ajout du conseiller client�le � la collection de conseillers client�les de l'agence
		gerant.getAgence().getConseillersClienteleAgence().add(conseillerClientele);
		
		// Valorisation de l'attribut monAgence du conseiller client�le
		conseillerClientele.setMonAgence(gerant.getAgence());
	}
	
//	/**
//	 * M�thode permettant de retirer un conseiller client�le d'une agence bancaire
//	 * @param agence : l'agence bancaire de laquelle on veut retirer un conseiller client�le
//	 * @param conseillerClientele : le conseiller client�le � retirer de l'agence bancaire
//	 */
//	public void retirerConseillerClientele(Agence agence, ConseillerClientele conseillerClientele) {
//		agence.getConseillersClienteleAgence().remove(conseillerClientele);
//	}
	
	public void retirerConseillerClientele(Gerant gerant, ConseillerClientele conseillerClientele) {
		// Retrait du conseiller client�le � la collection de conseillers client�les de l'agence
		gerant.getAgence().getConseillersClienteleAgence().remove(conseillerClientele);
		
		// R�initialisation de l'attribut monAgence du conseiller client�le
		conseillerClientele.setMonAgence(null);
	}
	
//	/**
//	 * M�thode permettant de faire un audit d'une agence bancaire
//	 * @param agence : l'agence bancaire que l'on veut auditer
//	 * @return tableau de 2 entiers [a,b], a : nombre de comptes particuliers d�biteurs de plus de 5000 euros
//	 * et b : nombre de comptes entreprises d�biteurs de plus de 50000 euros
//     */
//	public int[] auditerAgence (Agence agence) {
//		
//		int nbCompteParticulierDebiteur = 0;
//		int nbCompteEntrepriseDebiteur = 0;
//		int[] t = {0,0};
//		
//		// Pour tous les clients d'une agence
//		for (Client c : agence.getClientsAgence()) {
//			
//			// Si le client est de type ClientParticulier
//			if (c.getClass().isInstance(new ClientParticulier())) {
//				// Si le d�couvert du compte courant est sup�rieur � 5000
//				if ((c.getCompteCourant()).getSoldeCompte()<-5000) {
//					nbCompteParticulierDebiteur += 1;
//				}
//			}
//			
//			// Sinon, si le client est de type ClientEntreprise
//			else {
//				
//				// Si le d�couvert du compte courant est sup�rieur � 50000
//				if ((c.getCompteCourant()).getSoldeCompte()<-50000) {
//					nbCompteEntrepriseDebiteur += 1;
//				}
//			}
//		}
//			
//		t[0] = nbCompteParticulierDebiteur;
//		t[1] = nbCompteEntrepriseDebiteur;
//		// retourne un tableau contenant le nombre de comptes particuliers d�biteurs
//		// de plus de 5000 euros et le nombre de comptes entreprises d�biteurs de plus de 50000 euros
//		return t;
//	}

	/**
	 * M�thode permettant � un g�rant de proc�der � un audit de son agence bancaire
	 * @param gerant : le g�rant souhaitant proc�der � un audit de son agence bancaire
	 * @return un tableau de 2 entiers [a,b]
	 * a = nombre de comptes particuliers d�biteurs de plus de 5000 euros
	 * b = nombre de comptes entreprises d�biteurs de plus de 50000 euros
	 */
//	public int[] auditerAgence (Gerant gerant) {
//		
//		int nbCompteParticulierDebiteur = 0;
//		int nbCompteEntrepriseDebiteur = 0;
//		int[] t = {0,0};
//		
//		// Pour tous les clients d'une agence
//		for (Client c : gerant.getAgence().getClientsAgence()) {
//			
//			// Si le client est de type ClientParticulier
//			if (c.getClass().isInstance(new ClientParticulier())) {
//				// Si le d�couvert du compte courant est sup�rieur � 5000
//				if ((c.getCompteCourant()).getSoldeCompte()<-5000) {
//					nbCompteParticulierDebiteur += 1;
//				}
//			}
//			
//			// Sinon, si le client est de type ClientEntreprise
//			else {
//				// Si le d�couvert du compte courant est sup�rieur � 50000
//				if ((c.getCompteCourant()).getSoldeCompte()<-50000) {
//					nbCompteEntrepriseDebiteur += 1;
//				}
//			}
//		}
//			
//		t[0] = nbCompteParticulierDebiteur;
//		t[1] = nbCompteEntrepriseDebiteur;
//		// retourne un tableau contenant le nombre de comptes particuliers d�biteurs
//		// de plus de 5000 euros et le nombre de comptes entreprises d�biteurs de plus de 50000 euros
//		return t;
//	}
}
