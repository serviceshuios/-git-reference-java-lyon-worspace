package service;

import java.util.Date;

import javax.inject.Named;

import metier.Compte;
import metier.CompteEpargne;
import service.exceptions.MontantNegatifException;
import service.exceptions.SoldeInsuffisantException;

/**
 * La classe CompteEpargneService est associ�e � la classe m�tier CompteEpargne.
 * Elle permet de d�finir le CompteEpargne ProxiBanque.
 * Le compte �pargne est caract�ris� par le taux de r�mun�ration, par d�faut � 3%.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@Named
public class CompteEpargneService extends CompteService {

	/**
	 * M�thode permettant de cr�er un Compte de type CompteEpargne
	 * avec un taux de r�mun�ration par d�faut de 3% (demande de ProxiBanque)
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @return le compte �pargne cr��
	 */
	public Compte creerCompte(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		return new CompteEpargne(idCompte, soldeCompte, dateOuvertureCompte, 3);
	}
	
	/**
	 * Red�finition de la m�thode d�biter de la classe m�re CompteService
	 * @param c : le compte � d�biter
	 * @param montant : le montant � d�biter
	 * @return le solde du compte
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	@Override
	public double debiter(Compte c, double montant) throws SoldeInsuffisantException, MontantNegatifException {
		if (montant >= 0) {
			if (montant <= c.getSoldeCompte()) {
				c.setSoldeCompte(c.getSoldeCompte() - montant);
			} else throw new SoldeInsuffisantException("SOLDE INSUFFISANT");
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return c.getSoldeCompte();
	}
	
	/**
	 * M�thode sp�cifique � un compte de type CompteEpargne
	 * permettant de calculer les int�ts
	 * @param compte : le compte �pargne duquel on veut calculer les inter�ts
	 * @return les inter�ts calcul�s
	 */
	public double calculInterets(CompteEpargne compte) {
		return compte.getSoldeCompte()*(compte.getTauxRemuneration()/100);
	}
	
}
