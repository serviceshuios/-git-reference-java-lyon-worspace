package fr.huios.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import fr.huios.entities.Personne;
import fr.huios.service.IPersonneServiceLocal;

@SessionScoped
@ManagedBean
public class PersonneBean {

	private Long id;
	private String nom;
	private String prenom;
	
	@EJB
	private IPersonneServiceLocal service;
	
	
	
	public PersonneBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}


	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}


	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}


	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	/**
	 * @return the service
	 */
	public IPersonneServiceLocal getService() {
		return service;
	}


	/**
	 * @param service the service to set
	 */
	public void setService(IPersonneServiceLocal service) {
		this.service = service;
	}


	public String getCreerPersonne(){
		Personne p = new Personne();
		p.setNom(nom);
		p.setPrenom(prenom);
		service.ajouterPersonne(p);
		return "listePersonnes.xhtml?faces-redirect=true";
	}
	
	public List<Personne> getPersonnes(){
		List<Personne> personnes = service.findAll();
		return personnes;
	}
}
