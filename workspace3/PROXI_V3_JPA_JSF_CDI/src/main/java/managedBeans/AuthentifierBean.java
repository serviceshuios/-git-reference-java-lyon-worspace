package managedBeans;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import metier.ConseillerClientele;
import service.IConseillerClienteleService;

/**
 * 
 * Bean servant à gerer la session
 *
 */
@Named
@SessionScoped
public class AuthentifierBean implements Serializable{

	/* ----------------- Attributs ----------------- */

	// appel de la couche service
	@Inject
	private IConseillerClienteleService service;// = new ConseillerClienteleService();

	// objet ConseillerClientele permettant de récupérer les paramètres saisis
	// dans le formulaire
	private ConseillerClientele conseillerClientele = new ConseillerClientele();

	// objet ConseillerClientele permettant de gérer la connexion à proxibanque
	private ConseillerClientele conseillerConnecte;

	/* ----------------- Méthodes ----------------- */

	public String authentifier() {
		//System.out.println(conseillerClientele.getEmail() + " | " + conseillerClientele.getPassword());

		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext externalContext = context.getExternalContext();

		conseillerConnecte = service.authentifier(conseillerClientele.getEmail(), conseillerClientele.getPassword());

		externalContext.getSessionMap().put("conseillerConnecte", conseillerConnecte);

		if (conseillerConnecte == null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur d'authentification", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
			return "index";
		}

		FacesMessage message = new FacesMessage("Connecté");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return "listerClients";
	}

	public void deconnecter() {

		conseillerConnecte = null;
		conseillerClientele = new ConseillerClientele();

		FacesContext ctx = FacesContext.getCurrentInstance();

		try {
			ctx.getExternalContext().redirect("index.xhtml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/* ----------------- Getters & Setters ----------------- */

	public ConseillerClientele getConseillerClientele() {
		return conseillerClientele;
	}

	public void setConseillerClientele(ConseillerClientele conseillerClientele) {
		this.conseillerClientele = conseillerClientele;
	}

	public ConseillerClientele getConseillerConnecte() {
		return conseillerConnecte;
	}

	public void setConseillerConnecte(ConseillerClientele conseillerConnecte) {
		this.conseillerConnecte = conseillerConnecte;
	}

}
