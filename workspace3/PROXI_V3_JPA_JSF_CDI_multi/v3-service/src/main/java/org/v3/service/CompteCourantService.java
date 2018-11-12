package org.v3.service;

import java.util.Date;

import javax.inject.Named;

import org.v3.metier.Compte;
import org.v3.metier.CompteCourant;
import org.v3.service.exceptions.MontantNegatifException;
import org.v3.service.exceptions.SoldeInsuffisantException;



/**
 * La classe CompteCourantService est associ�e � la classe m�tier CompteCourant.
 * Elle permet de d�finir le CompteCourant ProxiBanque.
 * Le Compte courant ProxiBanque est caract�ris� par une autorisation de d�couvert par d�faut de 1000 euros.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@Named
public class CompteCourantService extends CompteService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * M�thode permettant de cr�er un Compte de type CompteCourant
	 * avec un d�couvert autoris� par d�faut de 1000 � (demande de ProxiBanque)
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte : la date d'ouverture du compte
	 * @return le compte courant cr��
	 */
	public Compte creerCompte(int idCompte, double soldeCompte, Date dateOuvertureCompte) {
		return new CompteCourant(idCompte, soldeCompte, dateOuvertureCompte, 1000);
	}
	
	/**
	 * Red�finition de la m�thode d�biter de la classe m�re CompteService
	 * g�rant le d�couvert autoris� propre � un compte courant
	 * @param c : le compte � d�biter
	 * @param montant : le montant � d�biter
	 * @return le solde du compte
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	@Override
	public double debiter(Compte c, double montant) throws SoldeInsuffisantException, MontantNegatifException {
		CompteCourant cc = (CompteCourant)c;
		if (montant >= 0) {
			if (montant <= cc.getSoldeCompte() + cc.getDecouvert()) {
				c.setSoldeCompte(c.getSoldeCompte() - montant);
			} else throw new SoldeInsuffisantException("SOLDE INSUFFISANT");
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return cc.getSoldeCompte();
	}
		
}
