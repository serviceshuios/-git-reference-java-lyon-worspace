package managedBeans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.v3.metier.Adresse;
import org.v3.metier.Client;
import org.v3.metier.ClientEntreprise;
import org.v3.metier.ClientParticulier;
import org.v3.metier.ConseillerClientele;
import org.v3.service.IConseillerClienteleService;
import org.v3.service.exceptions.NombreMaxClientsParConseillerException;



/**
 * 
 * Bean de la vue ajouter
 *
 */
@Named
@SessionScoped
public class AjouterClientBean implements Serializable{

	/* ----------------- Attributs ----------------- */

	/**
	 * 
	 */
	private static final long serialVersionUID = -1062327671456260696L;

	// appel de la couche service
	@Inject
	private IConseillerClienteleService service;// = new ConseillerClienteleService();

	// le conseiller clientèle courant
	private ConseillerClientele conseillerClientele; 
	
	private Client client;
	
	private String civilite;
	private String prenom;
	private String nom;
	private String rue;
	private String codePostal;
	private String ville;
	private String telephone;
	private String email;
	private String nomEntreprise;

	/* ----------------- Méthodes ----------------- */

	public String ajouter() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
	    conseillerClientele = service.chercherConseiller(((ConseillerClientele) externalContext.getSessionMap().get("conseillerConnecte")).getId());
	    //System.out.println("nbr de clients conseiller = " + conseillerClientele.getMesClients().size());
	    
	    if (nomEntreprise.equalsIgnoreCase("")) {
	    	client = new ClientParticulier();
	    } else {
	    	client = new ClientEntreprise();
	    }
	    
	    Adresse adresse = new Adresse(rue, codePostal, ville);
	    
	    client.setCivilite(civilite);
	    client.setPrenom(prenom);
	    client.setNom(nom);
	    client.setAdresse(adresse);
	    client.setTelephone(telephone);
	    client.setEmail(email);
	    client.setNomEntreprise(nomEntreprise);
	    client.setMonConseiller(conseillerClientele);
	    
		try {
			service.ajouterClient(conseillerClientele, client);
		} catch (NombreMaxClientsParConseillerException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null);
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
		return "listerClients";
	}

	/* ----------------- Getters & Setters ----------------- */
	
	public IConseillerClienteleService getService() {
		return service;
	}

	public void setService(IConseillerClienteleService service) {
		this.service = service;
	}

	public ConseillerClientele getConseillerClientele() {
		return conseillerClientele;
	}

	public void setConseillerClientele(ConseillerClientele conseillerClientele) {
		this.conseillerClientele = conseillerClientele;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	
}
