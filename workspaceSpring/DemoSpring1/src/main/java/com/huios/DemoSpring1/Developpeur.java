package com.huios.DemoSpring1;

public class Developpeur {

	private String nom;
	private String anneesExperience;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAnneesExperience() {
		return anneesExperience;
	}
	public void setAnneesExperience(String anneesExperience) {
		this.anneesExperience = anneesExperience;
	}
	@Override
	public String toString() {
		return "Developpeur [nom=" + nom + ", anneesExperience=" + anneesExperience + "]";
	}
}
