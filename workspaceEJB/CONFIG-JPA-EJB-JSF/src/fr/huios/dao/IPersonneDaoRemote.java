package fr.huios.dao;

import java.util.List;

import fr.huios.entities.Personne;

public interface IPersonneDaoRemote {
	public void ajouterPersonne (Personne p);
	public List<Personne> findAll();
}
