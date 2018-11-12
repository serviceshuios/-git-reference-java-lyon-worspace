package pjsf1.jsf.exos;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="mbclients", eager=true)
@SessionScoped
public class MBClients {

	//ClientService clientService ; 

	@ManagedProperty(value="#{clientservice}")
	private ClientService clientService;
	
	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}	
	
	public MBClients(){
		//clientService = new ClientService();
	}
	
	
	public ArrayList<Client> getClients(){
		return clientService.getClients();
	}

	public int getNombre(){
		return clientService.getClients().size();
	}
	
	
	
	//Choosing a client
	
	private Client clientCourant;
	
	public Client getClientCourant(){
		
		return clientCourant;
	}
	
	public String select(Client client){
		
		this.clientCourant = client;
		
		return "clientDisplay";
	}

	
	//Deleting a client
	
	public String delete(){
		
		clientService.delete(clientCourant);
		
		return "clients";
	}

	
	//Adding a client
	
	Client newClient = new Client("","");
	
	public Client getNewClient() {
		
		return newClient;
	}

	public void setNewClient(Client newClient) {
		
		this.newClient = newClient;
	}

	public String add(){
		
		clientService.add(newClient);
		
		newClient = new Client("","");
		
		return "clients";
	}

}
