package fr.huios.service;

import java.util.List;

import javax.ejb.Local;

import fr.huios.entities.Personne;
@Local
public interface IPersonneServiceLocal {

	public void ajouterPersonne (Personne p);
	public List<Personne> findAll();
}
