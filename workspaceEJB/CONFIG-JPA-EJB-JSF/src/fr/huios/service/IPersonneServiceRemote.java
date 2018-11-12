package fr.huios.service;

import java.util.List;

import javax.ejb.Remote;

import fr.huios.entities.Personne;
@Remote
public interface IPersonneServiceRemote {
	public void ajouterPersonne (Personne p);
	public List<Personne> findAll();
}
