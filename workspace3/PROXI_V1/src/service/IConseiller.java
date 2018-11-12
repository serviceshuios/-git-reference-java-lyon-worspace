package service;

import java.util.Date;

import metier.Client;
import metier.Compte;
import metier.Conseiller;
import metier.CreditConsommation;
import metier.CreditImmobilier;

public interface IConseiller {

	public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient, boolean estSociete, String nomSociete);
	public boolean creerClient (Conseiller conseiller, String nom, String prenom, String civilite, String numeroClient);
	public Client lireClient (Conseiller conseiller, String noClient);
	public void modificationCLient (Conseiller conseiller, Client clientAModifier,  String nom, String prenom, boolean estSociete, String nomSociete);
	public boolean supprimerClient(Conseiller conseiller, Client clientASupprimer);
	public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde,
			Date dateOuverture);
	public boolean creerCompteCourant(Client client, String numero, float solde, Date dateOuverture,
			boolean compteEntreprise);
	public boolean creerCompteEpargne(Client client, String numero, float soldeDepart, Date dateOuverture, boolean compteEntreprise);
	public void virementCompteACompte(Compte compteADebiter, Compte compteACrediter, float montant);
	public void simulerCreditImmobilier(Client client, CreditImmobilier creditImmo);
	public void simulerCreditConsommation(Client client, CreditConsommation creditConso);
	public boolean creerPlacement(Client client, Compte compte, float montant, String placeFinanciere);
	public boolean supprimerCompte(Conseiller conseiller, Client client, String typeCompte);
}
