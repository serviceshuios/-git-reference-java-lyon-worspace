package managedBeans;

import java.io.Serializable;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.v3.metier.Client;
import org.v3.metier.ConseillerClientele;
import org.v3.service.IConseillerClienteleService;



/**
 * 
 * Bean de la vue lister
 *
 */
//@Named	// pour dire que c'est un Bean dans le conteneur de CDI. @Named inclut @ManagedBean de JSF
//@ManagedBean(name="listerClientsBean")
//@RequestScoped
@Named
@SessionScoped
public class ListerClientsBean implements Serializable{

	/* ----------------- Attributs ----------------- */
	
	// appel de la couche service
	@Inject
	private IConseillerClienteleService service;// = new ConseillerClienteleService();
	
	// le conseiller clientèle courant
	private ConseillerClientele conseillerClientele; 
	
	// collection de clients affectés au conseiller identifié
	private Collection<Client> lesClients;
	
	// le client courant
	private Client client;
	
	
	/* ----------------- Méthodes -----------------	*/
	
	public Collection<Client> lister() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
	    conseillerClientele = service.chercherConseiller(((ConseillerClientele) externalContext.getSessionMap().get("conseillerConnecte")).getId());
        lesClients = service.listerClient(conseillerClientele);
		return lesClients;
	}
	
	public void supprimer() {
		FacesContext context = FacesContext.getCurrentInstance();
	    ExternalContext externalContext = context.getExternalContext();
		conseillerClientele = service.chercherConseiller(((ConseillerClientele) externalContext.getSessionMap().get("conseillerConnecte")).getId());
		service.supprimerClient(conseillerClientele, client);
	}
	
	/* ----------------- Getters & Setters ----------------- */
	
	public ConseillerClientele getConseillerClientele() {
		return conseillerClientele;
	}

	public void setConseillerClientele(ConseillerClientele conseillerClientele) {
		this.conseillerClientele = conseillerClientele;
	}

	public Collection<Client> getLesClients() {
		return lesClients;
	}

	public void setLesClients(Collection<Client> lesClients) {
		this.lesClients = lesClients;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
