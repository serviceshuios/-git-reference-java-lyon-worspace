package mbeans;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import metier.Client;
import service.Iservice;

@Named
@SessionScoped
public class ClientBean implements Serializable {

	@Inject
	private Iservice service;

	private Client client;
	private List<Client> clients;
	private boolean editMode = false;

	public ClientBean() {
		// TODO Auto-generated constructor stub
		client = new Client();
	}

	public Iservice getService() {
		return service;
	}

	public void setService(Iservice service) {
		this.service = service;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClients() {
		return service.getAllClients();
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	}

	public String add() {
		if (editMode == false) {
			if(!client.getNom().equalsIgnoreCase("")&&!client.getPrenom().equalsIgnoreCase(""))
			{
				service.addClient(client);
				client = new Client();
			}
			else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("client", new FacesMessage(FacesMessage.SEVERITY_ERROR,"veuillez saisir les valeurs non nulles",null));
			}
		} else {
			if(!client.getNom().equalsIgnoreCase("")&&!client.getPrenom().equalsIgnoreCase(""))
			{
			service.maj(client);
			editMode = false;
			client = new Client();
			}
			else {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage("client", new FacesMessage(FacesMessage.SEVERITY_ERROR,"veuillez saisir les valeurs non nulles",null));
			}
		}
		
		return "index";
	}

	public String deleteClient() {
		service.delete(client);
		client = new Client();
		return "index";
	}

	public void majClient() {
		//service.maj(client);
		editMode=true;
		//return "index";
	}
}
