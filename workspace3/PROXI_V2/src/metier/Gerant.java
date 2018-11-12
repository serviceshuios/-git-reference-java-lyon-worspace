package metier;

import java.util.ArrayList;
import java.util.Collection;

public class Gerant extends Personne{

	private Collection<Conseiller> conseillers = new ArrayList<Conseiller>();
	private Agence agence;

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Collection<Conseiller> getConseillers() {
		return conseillers;
	}

	public void setConseillers(Collection<Conseiller> conseillers) {
		this.conseillers = conseillers;
	}

	public Gerant(Collection<Conseiller> conseillers, Agence agence) {
		super();
		this.conseillers = conseillers;
		this.agence = agence;
	}

	public Gerant(Collection<Conseiller> conseillers) {
		super();
		this.conseillers = conseillers;
	}

	public Gerant() {
		super();
	}

	@Override
	public String toString() {
		return "Gerant [conseillers=" + conseillers + "]";
	}

}
