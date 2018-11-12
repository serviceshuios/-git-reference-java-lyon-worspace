package org.v3.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Named;

import org.v3.metier.Compte;
import org.v3.service.exceptions.MontantNegatifException;
import org.v3.service.exceptions.SoldeInsuffisantException;



/**
 * La classe abstraite service CompteService est associ�e � la classe m�tier Compte.
 * Elle permet d'effectuer les op�rations sp�cifiques sur les compte ProxiBanque.
 * @author S.BERNY - V.LE GAL
 * @version 2.0
 */
@Named 
public abstract class CompteService implements Serializable {

	/**
	 * M�thode abstraite permettant de cr�er un Compte
	 * Cette m�thode sera donc red�finie dans chaque classe fille
	 * @param idCompte : l'identifiant du compte
	 * @param soldeCompte : le solde du compte
	 * @param dateOuvertureCompte: la date d'ouverture du compte
	 * @return le compte cr��
	 */
	public abstract Compte creerCompte(int idCompte, double soldeCompte, Date dateOuvertureCompte);
	
	/**
	 * M�thode permettant de cr�diter un montant sur un compte
	 * @param c : le compte � cr�diter
	 * @param montant : le montant � cr�diter
	 * @return le solde du compte
	 * @throws MontantNegatifException
	 */
	public double crediter(Compte c, double montant) throws MontantNegatifException {
		if (montant >= 0) {
			c.setSoldeCompte(c.getSoldeCompte() + montant);
		} else throw new MontantNegatifException("MONTANT NEGATIF");
		return c.getSoldeCompte();
	}
	
	/**
	 * M�thode abstraite permettant de d�biter un montant sur un compte
	 * Cette m�thode sera red�finie dans chaque classe fille
	 * @param c : le compte � d�biter
	 * @param montant : le montant � d�biter
	 * @return le solde du compte
	 * @throws SoldeInsuffisantException
	 * @throws MontantNegatifException
	 */
	public abstract double debiter(Compte c, double montant) throws SoldeInsuffisantException, MontantNegatifException;
	
}
